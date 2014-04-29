/*
 * Copyright © 2014 <code@io7m.com> http://io7m.com
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jintegers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.io7m.jnull.NullCheck;
import com.io7m.junreachable.UnreachableCodeException;

/** 64-bit integer packing/unpacking functions. */

public final class Integer64
{
  /**
   * <p>
   * Pack <code>i</code> into a byte buffer <code>b</code> using a big-endian
   * encoding such that the most significant byte is in <code>b[0]</code>.
   * </p>
   * 
   * @param i
   *          The value to be packed.
   * @return A byte buffer containing the packed integer data.
   */

  public static byte[] packBigEndian(
    final long i)
  {
    final byte[] r = new byte[8];
    return Integer64.packBigEndianTo(i, r);
  }

  /**
   * <p>
   * Pack <code>i</code> into a byte buffer <code>r</code> using a big-endian
   * encoding such that the most significant byte is in <code>r[0]</code>.
   * </p>
   * 
   * @param r
   *          The buffer
   * @param i
   *          The value to be packed.
   * @return <code>r</code>
   */

  public static byte[] packBigEndianTo(
    final long i,
    final byte[] r)
  {
    NullCheck.notNull(r, "Buffer");
    if (r.length < 8) {
      throw new IllegalArgumentException("Buffer.length must be >= 8 (is "
        + r.length
        + ")");
    }

    long x = i;
    r[7] = (byte) (x & 0xff);
    x >>= 8;
    r[6] = (byte) (x & 0xff);
    x >>= 8;
    r[5] = (byte) (x & 0xff);
    x >>= 8;
    r[4] = (byte) (x & 0xff);
    x >>= 8;
    r[3] = (byte) (x & 0xff);
    x >>= 8;
    r[2] = (byte) (x & 0xff);
    x >>= 8;
    r[1] = (byte) (x & 0xff);
    x >>= 8;
    r[0] = (byte) (x & 0xff);
    return r;
  }

  /**
   * <p>
   * Pack <code>i</code> into a byte buffer <code>r</code> using a big-endian
   * encoding such that the most significant byte is in <code>r[index]</code>.
   * </p>
   * 
   * @param r
   *          The buffer.
   * @param i
   *          The value to be packed.
   * @param index
   *          The starting index.
   * @return <code>r</code>
   */

  public static ByteBuffer packBigEndianToBuffer(
    final long i,
    final ByteBuffer r,
    final int index)
  {
    NullCheck.notNull(r, "Buffer");

    long x = i;
    r.put(index + 7, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 6, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 5, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 4, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 3, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 2, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 1, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 0, (byte) (x & 0xff));
    return r;
  }

  /**
   * <p>
   * Pack <code>i</code> into a byte buffer <code>b</code> using a
   * little-endian encoding such that the least significant byte is in
   * <code>b[0]</code>.
   * </p>
   * 
   * @param i
   *          The value to be packed.
   * @return A byte buffer containing the packed integer data.
   */

  public static byte[] packLittleEndian(
    final long i)
  {
    final byte[] r = new byte[8];
    return Integer64.packLittleEndianTo(i, r);
  }

  /**
   * <p>
   * Pack <code>i</code> into a byte buffer <code>r</code> using a
   * little-endian encoding such that the least significant byte is in
   * <code>r[0]</code>.
   * </p>
   * 
   * @param r
   *          The buffer
   * @param i
   *          The value to be packed.
   * @return <code>r</code>
   */

  public static byte[] packLittleEndianTo(
    final long i,
    final byte[] r)
  {
    NullCheck.notNull(r, "Buffer");
    if (r.length < 8) {
      throw new IllegalArgumentException("Buffer.length must be >= 8 (is "
        + r.length
        + ")");
    }

    long x = i;
    r[0] = (byte) (x & 0xff);
    x >>= 8;
    r[1] = (byte) (x & 0xff);
    x >>= 8;
    r[2] = (byte) (x & 0xff);
    x >>= 8;
    r[3] = (byte) (x & 0xff);
    x >>= 8;
    r[4] = (byte) (x & 0xff);
    x >>= 8;
    r[5] = (byte) (x & 0xff);
    x >>= 8;
    r[6] = (byte) (x & 0xff);
    x >>= 8;
    r[7] = (byte) (x & 0xff);
    return r;
  }

  /**
   * <p>
   * Pack <code>i</code> into a byte buffer <code>r</code> using a
   * little-endian encoding such that the least significant byte is in
   * <code>r[index]</code>.
   * </p>
   * 
   * @param r
   *          The buffer.
   * @param i
   *          The value to be packed.
   * @param index
   *          The starting index.
   * @return <code>r</code>
   */

  public static ByteBuffer packLittleEndianToBuffer(
    final long i,
    final ByteBuffer r,
    final int index)
  {
    NullCheck.notNull(r, "Buffer");

    long x = i;
    r.put(index + 0, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 1, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 2, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 3, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 4, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 5, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 6, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 7, (byte) (x & 0xff));
    return r;
  }

  /**
   * <p>
   * Pack <code>i</code> into a byte buffer <code>r</code> using the encoding
   * returned by {@link ByteBuffer#order()}, starting at <code>index</code>.
   * </p>
   * 
   * @param r
   *          The buffer.
   * @param i
   *          The value to be packed.
   * @param index
   *          The starting index.
   * @return <code>r</code>
   */

  public static ByteBuffer packToBuffer(
    final long i,
    final ByteBuffer r,
    final int index)
  {
    NullCheck.notNull(r, "Buffer");

    if (r.order().equals(ByteOrder.BIG_ENDIAN)) {
      return Integer64.packBigEndianToBuffer(i, r, index);
    }
    return Integer64.packLittleEndianToBuffer(i, r, index);
  }

  /**
   * <p>
   * Unpack an integer from <code>buffer</code> assuming a big-endian encoding
   * such that the most significant byte is in <code>b[0]</code>.
   * </p>
   * <p>
   * The function throws {@link NullPointerException} if
   * <code>buffer == null</code> and {@link IllegalArgumentException} if
   * <code>buffer.length</code> is too small to contain a packed integer value
   * of this size.
   * </p>
   * 
   * @param buffer
   *          The buffer from which to unpack data
   * @return A 64 bit integer value
   */

  public static long unpackBigEndian(
    final byte[] buffer)
  {
    NullCheck.notNull(buffer, "Buffer");
    if (buffer.length < 8) {
      throw new IllegalArgumentException("Buffer.length must be >= 8 (is "
        + buffer.length
        + ")");
    }

    long r = 0;
    r |= buffer[0] & 0xFF;
    r <<= 8;
    r |= buffer[1] & 0xFF;
    r <<= 8;
    r |= buffer[2] & 0xFF;
    r <<= 8;
    r |= buffer[3] & 0xFF;
    r <<= 8;
    r |= buffer[4] & 0xFF;
    r <<= 8;
    r |= buffer[5] & 0xFF;
    r <<= 8;
    r |= buffer[6] & 0xFF;
    r <<= 8;
    r |= buffer[7] & 0xFF;
    return r;
  }

  /**
   * <p>
   * Unpack an integer from <code>buffer</code> assuming a big-endian encoding
   * such that the most significant byte is in <code>b[index]</code>.
   * </p>
   * 
   * @param index
   *          The starting index in the buffer.
   * @param buffer
   *          The buffer from which to unpack data.
   * @return A 64 bit integer value.
   */

  public static long unpackBigEndianFromBuffer(
    final ByteBuffer buffer,
    final int index)
  {
    NullCheck.notNull(buffer, "Buffer");

    long r = (buffer.get(index) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 1) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 2) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 3) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 4) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 5) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 6) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 7) & 0xff);
    return r;
  }

  /**
   * <p>
   * Unpack an integer from <code>buffer</code> using the encoding returned by
   * {@link ByteBuffer#order()}, starting at <code>index</code>.
   * </p>
   * 
   * @param index
   *          The starting index
   * @param buffer
   *          The buffer from which to unpack data.
   * @return A 32 bit integer value.
   */

  public static long unpackFromBuffer(
    final ByteBuffer buffer,
    final int index)
  {
    NullCheck.notNull(buffer, "Buffer");

    if (buffer.order().equals(ByteOrder.BIG_ENDIAN)) {
      return Integer64.unpackBigEndianFromBuffer(buffer, index);
    }
    return Integer64.unpackLittleEndianFromBuffer(buffer, index);
  }

  /**
   * <p>
   * Unpack an integer from <code>buffer</code> assuming a little-endian
   * encoding such that the least significant byte is in <code>b[0]</code>.
   * </p>
   * <p>
   * The function throws {@link NullPointerException} if
   * <code>buffer == null</code> and {@link IllegalArgumentException} if
   * <code>buffer.length</code> is too small to contain a packed integer value
   * of this size.
   * </p>
   * 
   * @param buffer
   *          The buffer from which to unpack data
   * @return A 64 bit integer value
   */

  public static long unpackLittleEndian(
    final byte[] buffer)
  {
    NullCheck.notNull(buffer, "Buffer");
    if (buffer.length < 8) {
      throw new IllegalArgumentException("Buffer.length must be >= 8 (is "
        + buffer.length
        + ")");
    }

    long r = 0;
    r |= buffer[7] & 0xFF;
    r <<= 8;
    r |= buffer[6] & 0xFF;
    r <<= 8;
    r |= buffer[5] & 0xFF;
    r <<= 8;
    r |= buffer[4] & 0xFF;
    r <<= 8;
    r |= buffer[3] & 0xFF;
    r <<= 8;
    r |= buffer[2] & 0xFF;
    r <<= 8;
    r |= buffer[1] & 0xFF;
    r <<= 8;
    r |= buffer[0] & 0xFF;
    return r;
  }

  /**
   * <p>
   * Unpack an integer from <code>buffer</code> assuming a little-endian
   * encoding such that the least significant byte is in <code>b[index]</code>
   * .
   * </p>
   * 
   * @param index
   *          The starting index
   * @param buffer
   *          The buffer from which to unpack data.
   * @return A 64 bit integer value.
   */

  public static long unpackLittleEndianFromBuffer(
    final ByteBuffer buffer,
    final int index)
  {
    NullCheck.notNull(buffer, "Buffer");

    long r = (buffer.get(index + 7) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 6) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 5) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 4) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 3) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 2) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 1) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 0) & 0xff);
    return r;
  }

  private Integer64()
  {
    throw new UnreachableCodeException();
  }
}
