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

package com.ardikars.jxnet.util;

/**
 * @author Ardika Rommy Sanjaya
 * @since 1.0.0
 */
public final class Pointer {
	
	private long address;

	/**
	 * Get pointer address.
	 * @return pointer address.
	 */
	public long getAddress() {
		return address;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj.getClass() != getClass())
			return false;
		if (obj instanceof Pointer) {
			Pointer pointer = (Pointer) obj;
			return address == pointer.getAddress();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 17 * 37 +
				((int) (address ^ (address >> 32))) + super.hashCode();
	}

	@Override
	public String toString() {
		return new StringBuilder().append("[Address: ")
				.append(address).append("]").toString();
	}

}