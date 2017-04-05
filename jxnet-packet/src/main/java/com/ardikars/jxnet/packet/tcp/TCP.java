/**
 * Copyright (C) 2017  Ardika Rommy Sanjaya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ardikars.jxnet.packet.tcp;

import com.ardikars.jxnet.packet.Packet;
import com.ardikars.jxnet.util.Builder;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author Ardika Rommy Sanjaya
 * @since 1.1.0
 */
public class TCP extends Packet implements Builder<Packet> {

    public static int TCP_HEADER_LENGTH = 20;

    private short sourcePort;
    private short destinationPort;
    private int sequence;
    private int acknowledge;
    private byte dataOffset;
    private short flags;
    private short windowSize;
    private short checksum;
    private short urgentPointer;
    private byte[] options;

    private byte[] payload;

    public TCP() {

    }

    public short getSourcePort() {
        return (short) (this.sourcePort & 0xffff);
    }

    public TCP setSourcePort(final short sourcePort) {
        this.sourcePort = (short) (sourcePort & 0xffff);
        return this;
    }

    public short getDestinationPort() {
        return (short) (this.destinationPort & 0xffff);
    }

    public TCP setDestinationPort(final short destinationPort) {
        this.destinationPort = (short) (destinationPort & 0xffff);
        return this;
    }

    public int getSequence() {
        return (int) (this.sequence & 0xffffffffL);
    }

    public TCP setSequence(final int sequence) {
        this.sequence = (int) (sequence & 0xffffffffL);
        return this;
    }

    public int getAcknowledge() {
        return (int) (this.acknowledge & 0xffffffffL);
    }

    public TCP setAcknowledge(final int acknowledge) {
        this.acknowledge = (int) (acknowledge & 0xffffffffL);
        return this;
    }

    public byte getDataOffset() {
        return (byte) (this.dataOffset & 0xf);
    }

    public TCP setDataOffset(final byte dataOffset) {
        this.dataOffset = (byte) (dataOffset & 0xf);
        return this;
    }

    public short getFlags() {
        return (short) (this.flags & 0x1ff);
    }

    public TCP setFlags(final short flags) {
        this.flags = (short) (flags & 0x1ff);;
        return this;
    }

    public short getWindowSize() {
        return (short) (this.windowSize & 0xffff);
    }

    public TCP setWindowSize(final short windowSize) {
        this.windowSize = (short) (windowSize & 0xffff);
        return this;
    }

    public short getChecksum() {
        return (short) (this.checksum & 0xffff);
    }

    public TCP setChecksum(final short checksum) {
        this.checksum = (short) (checksum & 0xffff);
        return this;
    }

    public short getUrgentPointer() {
        return (short) (this.urgentPointer & 0xffff);
    }

    public TCP setUrgentPointer(final short urgentPointer) {
        this.urgentPointer = (short) (urgentPointer & 0xffff);
        return this;
    }

    public byte[] getOptions() {
        return this.options;
    }

    public TCP setOptions(final byte[] options) {
        this.options = options;
        return this;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public TCP setPayload(final byte[] payload) {
        this.payload = payload;
        return this;
    }

    public static TCP newInstance(final byte[] bytes) {
        return newInstance(bytes, 0, bytes.length);
    }

    public static TCP newInstance(final byte[] bytes, final int offset, final int length) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes, offset, length);
        TCP tcp = new TCP();
        tcp.setSourcePort(buffer.getShort());
        tcp.setDestinationPort(buffer.getShort());
        tcp.setSequence(buffer.getInt());
        tcp.setAcknowledge(buffer.getInt());
        tcp.flags = buffer.getShort();
        tcp.setDataOffset((byte) (tcp.flags >> 12 & 0xf));
        tcp.setFlags((short) (tcp.flags & 0x1ff));
        tcp.setWindowSize(buffer.getShort());
        tcp.setChecksum(buffer.getShort());
        tcp.setUrgentPointer(buffer.getShort());
        if (tcp.getDataOffset() > 5) {
            int optionLength = (tcp.getDataOffset() << 2) - TCP_HEADER_LENGTH;
            if (buffer.limit() < buffer.position() + optionLength) {
                optionLength = buffer.limit() - buffer.position();
            }
            tcp.options = new byte[optionLength];
            buffer.get(tcp.options, 0, optionLength);
            tcp.payload = new byte[(buffer.limit() - (TCP_HEADER_LENGTH + optionLength))];
            buffer.get(tcp.payload);
        } else {
            tcp.setOptions(null);
            tcp.payload = new byte[(buffer.limit() - TCP_HEADER_LENGTH)];
            buffer.get(tcp.payload);
        }
        return tcp;
    }

    @Override
    public Packet setPacket(final Packet packet) {
        this.payload = packet.toBytes();
        return this;
    }

    @Override
    public Packet getPacket() {
        return null;
    }

    @Override
    public byte[] toBytes() {
        byte[] data = new byte[TCP_HEADER_LENGTH + ((options == null) ? 0 : options.length) +
                ((this.getPayload() == null) ? 0 : this.getPayload().length)];
        ByteBuffer buffer = ByteBuffer.wrap(data);
        buffer.putShort(this.getSourcePort());
        buffer.putShort(this.getDestinationPort());
        buffer.putInt(this.getSequence());
        buffer.putInt(this.getAcknowledge());
        buffer.putShort((short) ((this.getFlags() & 0x1ff) | (this.getDataOffset() & 0xf) << 12));
        buffer.putShort(this.getWindowSize());
        buffer.putShort(this.getChecksum());
        buffer.putShort(this.getUrgentPointer());
        if (this.getOptions() != null)
            buffer.put(this.getOptions());
        if (this.getPayload() != null)
            buffer.put(this.getPayload());
        return data;
    }

    @Override
    public Packet build() {
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[")
                .append("Source port: " + this.getSourcePort())
                .append(", Destination port: " + this.getDestinationPort())
                .append(", Sequence number: " + this.getSequence())
                .append(", Acknowledgment number: " + this.getAcknowledge())
                .append(", Data offset: " + this.getDataOffset())
                .append(", Flags: " + this.getFlags())
                .append(", Windows size: " + this.getWindowSize())
                .append(", Checksum: " + this.getChecksum())
                .append(", Urgent pointer: " + this.getUrgentPointer())
                .append(", Options: " + Arrays.toString(getOptions()))
                .append("]").toString();
    }

}
