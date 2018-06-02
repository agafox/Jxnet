/**
 * Copyright (C) 2017-2018  Ardika Rommy Sanjaya <contact@ardikars.com>
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
 * @since 1.1.5
 */
public final class Validate {

    private Validate() {

    }

    /**
     * Check null pointer.
     * @param reference reference.
     * @param exception NullPointerException.
     * @param <T> type of reference.
     */
    public static <T> void nullPointer(final T reference, final NullPointerException exception) {
        if (reference == null) {
            if (exception == null) {
                throw new NullPointerException();
            } else {
                throw exception;
            }
        }
    }

    /**
     * Check null pointer.
     * @param reference reference.
     * @param <T> type of reference.
     */
    public static <T> void nullPointer(final T reference) {
        nullPointer(reference, null);
    }

    /**
     * Check null pointer.
     * @param reference reference.
     * @param newVal new value.
     * @param <T> type of reference and new value.
     * @return reference if not null, newVal otherwise.
     */
    public static <T> T nullPointer(final T reference, final T newVal) {
        if (reference == null) {
            return newVal;
        } else {
            return reference;
        }
    }

    /**
     * Check illegal argument.
     * @param expression expression.
     * @param exception IllegalArgumentException.
     */
    public static void illegalArgument(final boolean expression, final IllegalArgumentException exception) {
        if (!expression) {
            if (exception == null) {
                throw new IllegalArgumentException();
            } else {
                throw exception;
            }
        }
    }

    /**
     * Check illegal argument.
     * @param expression expression.
     */
    public static void illegalArgument(final boolean expression) {
        illegalArgument(expression, null);
    }

    /**
     * Check illegal argument.
     * @param expression expression.
     * @param reference reference.
     * @param newVal new value.
     * @param <T> type of reference and new value.
     * @return reference if not null, newVal otherwise.
     */
    public static <T> T illegalArgument(final boolean expression, final T reference, final T newVal) {
        if (!expression) {
            return newVal;
        } else {
            return reference;
        }
    }

    /**
     * Indicates whether obj1 is equal to obj2.
     * @param obj1 object 1.
     * @param obj2 object 2.
     * @param newVal new value.
     * @param <T> type of object.
     * @return obj1 if obj1 equal to obj2, newVal otherwise.
     */
    public static <T> T equals(final T obj1, final T obj2, final T newVal) {
        return obj1.equals(obj2) ? obj1 : newVal;
    }

    /**
     * Validate bounds.
     * @param array array.
     * @param offset offset.
     * @param length length.
     */
    public static void bounds(final byte[] array, final int offset, final int length) {
        nullPointer(array, new NullPointerException("array is null."));
        illegalArgument(array.length > 0, new IllegalArgumentException("array is empty."));
        illegalArgument(length > 0, new IllegalArgumentException("length is zero."));
        if (offset < 0 || length < 0 || length > array.length - 1 || offset > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Validate bounds.
     * @param array array.
     * @param offset offset.
     * @param length length.
     */
    public static void bounds(final char[] array, final int offset, final int length) {
        nullPointer(array, new NullPointerException("array is null."));
        illegalArgument(array.length > 0, new IllegalArgumentException("array is empty."));
        illegalArgument(length > 0, new IllegalArgumentException("length is zero."));
        if (offset < 0 || length < 0 || length > array.length - 1 || offset > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Validate bounds.
     * @param array array.
     * @param offset offset.
     * @param length length.
     */
    public static void bounds(final short[] array, final int offset, final int length) {
        nullPointer(array, new NullPointerException("array is null."));
        illegalArgument(array.length > 0, new IllegalArgumentException("array is empty."));
        illegalArgument(length > 0, new IllegalArgumentException("length is zero."));
        if (offset < 0 || length < 0 || length > array.length - 1 || offset > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Validate bounds.
     * @param array array.
     * @param offset offset.
     * @param length length.
     */
    public static void bounds(final int[] array, final int offset, final int length) {
        nullPointer(array, new NullPointerException("array is null."));
        illegalArgument(array.length > 0, new IllegalArgumentException("array is empty."));
        illegalArgument(length > 0, new IllegalArgumentException("length is zero."));
        if (offset < 0 || length < 0 || length > array.length - 1 || offset > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Validate bounds.
     * @param array array.
     * @param offset offset.
     * @param length length.
     */
    public static void bounds(final float[] array, final int offset, final int length) {
        nullPointer(array, new NullPointerException("array is null."));
        illegalArgument(array.length > 0, new IllegalArgumentException("array is empty."));
        illegalArgument(length > 0, new IllegalArgumentException("length is zero."));
        if (offset < 0 || length < 0 || length > array.length - 1 || offset > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Validate bounds.
     * @param array array.
     * @param offset offset.
     * @param length length.
     */
    public static void bounds(final long[] array, final int offset, final int length) {
        nullPointer(array, new NullPointerException("array is null."));
        illegalArgument(array.length > 0, new IllegalArgumentException("array is empty."));
        illegalArgument(length > 0, new IllegalArgumentException("length is zero."));
        if (offset < 0 || length < 0 || length > array.length - 1 || offset > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Validate bounds.
     * @param array array.
     * @param offset offset.
     * @param length length.
     */
    public static void bounds(final double[] array, final int offset, final int length) {
        nullPointer(array, new NullPointerException("array is null."));
        illegalArgument(array.length > 0, new IllegalArgumentException("array is empty."));
        illegalArgument(length > 0, new IllegalArgumentException("length is zero."));
        if (offset < 0 || length < 0 || length > array.length - 1 || offset > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Validate bounds.
     * @param array array.
     * @param offset offset.
     * @param length length.
     * @param <T> type of array.
     */
    public static <T> void bounds(final T[] array, final int offset, final int length) {
        nullPointer(array, new NullPointerException("array is null."));
        illegalArgument(array.length > 0, new IllegalArgumentException("array is empty."));
        illegalArgument(length > 0, new IllegalArgumentException("length is zero."));
        if (offset < 0 || length < 0 || length > array.length - 1 || offset > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Check value in range.
     * @param start start.
     * @param end end.
     * @param value value.
     * @param <T> type of Number.
     */
    public static <T extends Number & Comparable<T>> void between(final T start, final T end, final T value) {
        illegalArgument(!(start.compareTo(end) >= 0), new IllegalArgumentException("start (" + start
                + ") should be less then end (" + end + ")."));
        illegalArgument(value.compareTo(start) >= 0 && value.compareTo(end) <= 0,
                new IllegalArgumentException(value + " not in range between "
                        + start + " and " + end + "."));
    }

}