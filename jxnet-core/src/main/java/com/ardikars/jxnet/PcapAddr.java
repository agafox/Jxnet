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

package com.ardikars.jxnet;

import com.ardikars.common.annotation.Mutable;
import com.ardikars.jxnet.exception.OperationNotSupportedException;

/**
 * Representation of an interface address, used by Jxnet.PcapFindAllDevs().
 *
 * @author <a href="mailto:contact@ardikars.com">Ardika Rommy Sanjaya</a>
 * @since 1.0.0
 */
@Mutable(volatiles = { "addr", "netmask", "broadaddr", "dstaddr" })
public final class PcapAddr implements Cloneable {
	
	private volatile SockAddr addr = new SockAddr();
	
	private volatile SockAddr netmask = new SockAddr();
	
	private volatile SockAddr broadaddr = new SockAddr();
	
	private volatile SockAddr dstaddr = new SockAddr();

	private PcapAddr() {
		//
	}

	/**
	 * This method will throws {@code OperationNotSupportedException}.
	 * See {@code Jxnet.PcapFinaAllDevs}.
	 * @return nothing.
	 */
	public static PcapAddr newInstance() {
		throw new OperationNotSupportedException("Cannot instantiated directly, please use Jxnet.PcapFindAllDev().");
	}

	/**
	 * Getting interface address.
	 * @return returns interface address.
	 */
	public SockAddr getAddr() {
		SockAddr sockAddr = null;
		if (this.addr != null) {
			try {
				sockAddr = (SockAddr) this.addr.clone();
			} catch (CloneNotSupportedException e) {
				sockAddr = null;
			}
		}
		return sockAddr;
	}

	/**
	 * Getting interface netmask.
	 * @return returns interface netmask.
	 */
	public SockAddr getNetmask() {
		SockAddr sockAddr = null;
		if (this.netmask != null) {
			try {
				sockAddr = (SockAddr) this.netmask.clone();
			} catch (CloneNotSupportedException e) {
				sockAddr = null;
			}
		}
		return sockAddr;
	}

	/**
	 * Getting interface broadcast address.
	 * @return returns interface broadcast address.
	 */
	public SockAddr getBroadAddr() {
		SockAddr sockAddr = null;
		if (this.broadaddr != null) {
			try {
				sockAddr = (SockAddr) this.broadaddr.clone();
			} catch (CloneNotSupportedException e) {
				sockAddr = null;
			}
		}
		return sockAddr;
	}

	/**
	 * Getting interface destination address.
	 * @return returns interface destination address.
	 */
	public SockAddr getDstAddr() {
		SockAddr sockAddr = null;
		if (this.dstaddr != null) {
			try {
				sockAddr = (SockAddr) this.dstaddr.clone();
			} catch (CloneNotSupportedException e) {
				sockAddr = null;
			}
		}
		return sockAddr;
	}


	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final PcapAddr pcapAddr = (PcapAddr) o;

		if (!this.getAddr().equals(pcapAddr.getAddr())) {
			return false;
		}
		if (!this.getNetmask().equals(pcapAddr.getNetmask())) {
			return false;
		}
		if (!this.getBroadAddr().equals(pcapAddr.getBroadAddr())) {
			return false;
		}
		return this.getDstAddr().equals(pcapAddr.getDstAddr());
	}

	@Override
	public int hashCode() {
		int result = this.getAddr().hashCode();
		result = 31 * result + this.getNetmask().hashCode();
		result = 31 * result + this.getBroadAddr().hashCode();
		result = 31 * result + this.getDstAddr().hashCode();
		return result;
	}

	@Override
	public PcapAddr clone() throws CloneNotSupportedException {
		return  (PcapAddr) super.clone();
	}

	@Override
	public String toString() {
		return new StringBuilder(63)
				.append("PcapAddr{addr=").append(this.addr)
				.append(", netmask=").append(this.netmask)
				.append(", broadaddr=").append(this.broadaddr)
				.append(", dstaddr=").append(this.dstaddr)
				.append('}')
				.toString();
	}

}
