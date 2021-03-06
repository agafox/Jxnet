/**
 * Copyright (C) 2015-2018 Jxnet
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

package com.ardikars.jxnet.spring.boot.autoconfigure;

import com.ardikars.jxnet.Context;
import com.ardikars.jxnet.DataLinkType;
import com.ardikars.jxnet.ImmediateMode;
import com.ardikars.jxnet.Jxnet;
import com.ardikars.jxnet.Pcap;
import com.ardikars.jxnet.PcapDirection;
import com.ardikars.jxnet.PcapTimestampPrecision;
import com.ardikars.jxnet.PcapTimestampType;
import com.ardikars.jxnet.PromiscuousMode;
import com.ardikars.jxnet.RadioFrequencyMonitorMode;
import javax.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Spring autoconfiguration properties.
 *
 * @author <a href="mailto:contact@ardikars.com">Ardika Rommy Sanjaya</a>
 * @since 1.4.0
 */
@ConditionalOnClass({Context.class, Jxnet.class})
@ConfigurationProperties(prefix = "jxnet")
public class JxnetConfigurationProperties {

    private String source;

    private Integer snapshot;

    private PromiscuousMode promiscuous;

    private Integer timeout;

    private ImmediateMode immediate;

    private PcapTimestampType timestampType;

    private PcapTimestampPrecision timestampPrecision;

    private RadioFrequencyMonitorMode rfmon;

    private Boolean blocking;

    private PcapDirection direction;

    private Integer datalink;

    private String file;

    private Pcap.PcapType pcapType;

    private Integer numberOfThread;

    /**
     * Initialize field.
     */
    @PostConstruct
    public void initialize() {
        if (pcapType == null) {
            pcapType = Pcap.PcapType.LIVE;
        }
        if (snapshot == null || snapshot <= 0) {
            snapshot = 65535;
        }
        if (timestampType == null) {
            timestampType = PcapTimestampType.HOST;
        }
        if (timestampPrecision == null) {
            timestampPrecision = PcapTimestampPrecision.MICRO;
        }
        if (datalink == null) {
            datalink = (int) DataLinkType.EN10MB.getValue();
        }
        if (promiscuous == null) {
            promiscuous = PromiscuousMode.PROMISCUOUS;
        }
        if (timeout == null || timeout <= 0) {
            timeout = 2000;
        }
        if (immediate == null) {
            immediate = ImmediateMode.IMMEDIATE;
        }
        if (direction == null) {
            direction = PcapDirection.PCAP_D_INOUT;
        }
        if (rfmon == null) {
            rfmon = RadioFrequencyMonitorMode.NON_RFMON;
        }
        if (blocking == null) {
            blocking = false;
        }
        if (file == null) {
            file = null;
        }
        if (numberOfThread == null) {
            numberOfThread = 0;
        }
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(Integer snapshot) {
        this.snapshot = snapshot;
    }

    public PromiscuousMode getPromiscuous() {
        return promiscuous;
    }

    public void setPromiscuous(PromiscuousMode promiscuous) {
        this.promiscuous = promiscuous;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public ImmediateMode getImmediate() {
        return immediate;
    }

    public void setImmediate(ImmediateMode immediate) {
        this.immediate = immediate;
    }

    public PcapTimestampType getTimestampType() {
        return timestampType;
    }

    public void setTimestampType(PcapTimestampType timestampType) {
        this.timestampType = timestampType;
    }

    public PcapTimestampPrecision getTimestampPrecision() {
        return timestampPrecision;
    }

    public void setTimestampPrecision(PcapTimestampPrecision timestampPrecision) {
        this.timestampPrecision = timestampPrecision;
    }

    public RadioFrequencyMonitorMode getRfmon() {
        return rfmon;
    }

    public void setRfmon(RadioFrequencyMonitorMode rfmon) {
        this.rfmon = rfmon;
    }

    public Boolean getBlocking() {
        return blocking;
    }

    public void setBlocking(Boolean blocking) {
        this.blocking = blocking;
    }

    public PcapDirection getDirection() {
        return direction;
    }

    public void setDirection(PcapDirection direction) {
        this.direction = direction;
    }

    public DataLinkType getDatalink() {
        return DataLinkType.valueOf(datalink.shortValue());
    }

    public void setDatalink(Integer datalink) {
        this.datalink = datalink;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Pcap.PcapType getPcapType() {
        return pcapType;
    }

    public void setPcapType(Pcap.PcapType pcapType) {
        this.pcapType = pcapType;
    }

    public Integer getNumberOfThread() {
        return numberOfThread;
    }

    public void setNumberOfThread(Integer numberOfThread) {
        this.numberOfThread = numberOfThread;
    }

}
