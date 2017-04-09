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

import com.io7m.jnull.NullCheck;
import com.io7m.junreachable.UnreachableCodeException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 24-bit integer packing/unpacking functions.
 */

public final class Signed24
{
  private Signed24()
  {
    throw new UnreachableCodeException();
  }

  /**
   * <p>
   * Pack {@code i} into a byte buffer {@code b} using a big-endian
   * encoding such that the most significant byte is in {@code b[0]}.
   * </p>
   *
   * @param i The value to be packed.
   *
   * @return A byte buffer containing the packed integer data.
   */

  public static byte[] packToBytesBigEndianAllocate(
    final int i)
  {
    final byte[] r = new byte[3];
    return packToBytesBigEndian(i, r);
  }

  /**
   * <p>
   * Pack {@code i} into a byte buffer {@code r} using a big-endian
   * encoding such that the most significant byte is in {@code r[0]}.
   * </p>
   *
   * @param r The buffer
   * @param i The value to be packed.
   *
   * @return {@code r}
   */

  public static byte[] packToBytesBigEndian(
    final int i,
    final byte[] r)
  {
    NullCheck.notNull(r, "Buffer");
    if (r.length < 3) {
      throw new IllegalArgumentException(
        "Buffer.length must be >= 3 (is " + r.length + ")");
    }

    r[0] = (byte) (i >> 16);
    r[1] = (byte) (i >> 8);
    r[2] = (byte) (i & 0xff);
    return r;
  }

  /**
   * <p>
   * Pack {@code i} into a byte buffer {@code r} using a big-endian
   * encoding such that the most significant byte is in {@code r[index]}.
   * </p>
   *
   * @param r     The buffer.
   * @param i     The value to be packed.
   * @param index The starting index.
   *
   * @return {@code r}
   */

  public static ByteBuffer packToBufferBigEndian(
    final int i,
    final ByteBuffer r,
    final int index)
  {
    NullCheck.notNull(r, "Buffer");

    r.put(index + 0, (byte) (i >> 16));
    r.put(index + 1, (byte) (i >> 8));
    r.put(index + 2, (byte) (i & 0xff));
    return r;
  }

  /**
   * <p>
   * Pack {@code i} into a byte buffer {@code b} using a
   * little-endian encoding such that the least significant byte is in
   * {@code b[0]}.
   * </p>
   *
   * @param i The value to be packed.
   *
   * @return A byte buffer containing the packed integer data.
   */

  public static byte[] packToBytesLittleEndianAllocate(
    final int i)
  {
    final byte[] r = new byte[3];
    return packToBytesLittleEndian(i, r);
  }

  /**
   * <p>
   * Pack {@code i} into a byte buffer {@code r} using a
   * little-endian encoding such that the least significant byte is in
   * {@code b[0]}.
   * </p>
   *
   * @param r The buffer
   * @param i The value to be packed.
   *
   * @return {@code r}
   */

  public static byte[] packToBytesLittleEndian(
    final int i,
    final byte[] r)
  {
    NullCheck.notNull(r, "Buffer");
    if (r.length < 3) {
      throw new IllegalArgumentException(
        "Buffer.length must be >= 3 (is " + r.length + ")");
    }

    r[0] = (byte) (i & 0xff);
    r[1] = (byte) (i >> 8);
    r[2] = (byte) (i >> 16);
    return r;
  }

  /**
   * <p>
   * Pack {@code i} into a byte buffer {@code r} using a
   * little-endian encoding such that the least significant byte is in
   * {@code r[index]}.
   * </p>
   *
   * @param r     The buffer.
   * @param i     The value to be packed.
   * @param index The starting index.
   *
   * @return {@code r}
   */

  public static ByteBuffer packToBufferLittleEndian(
    final int i,
    final ByteBuffer r,
    final int index)
  {
    NullCheck.notNull(r, "Buffer");

    r.put(index + 0, (byte) (i & 0xff));
    r.put(index + 1, (byte) (i >> 8));
    r.put(index + 2, (byte) (i >> 16));
    return r;
  }

  /**
   * <p>
   * Pack {@code i} into a byte buffer {@code r} using the encoding
   * returned by {@link ByteBuffer#order()}, starting at {@code index}.
   * </p>
   *
   * @param r     The buffer.
   * @param i     The value to be packed.
   * @param index The starting index.
   *
   * @return {@code r}
   */

  public static ByteBuffer packToBuffer(
    final int i,
    final ByteBuffer r,
    final int index)
  {
    NullCheck.notNull(r, "Buffer");

    if (r.order().equals(ByteOrder.BIG_ENDIAN)) {
      return packToBufferBigEndian(i, r, index);
    }
    return packToBufferLittleEndian(i, r, index);
  }

  /**
   * <p>
   * Unpack an integer from {@code buffer} assuming a big-endian encoding
   * such that the most significant byte is in {@code b[0]}.
   * </p>
   * <p>
   * The function throws {@link NullPointerException} if
   * {@code buffer == null} and {@link IllegalArgumentException} if
   * {@code buffer.length} is too small to contain a packed integer value
   * of this size.
   * </p>
   *
   * @param buffer The buffer from which to unpack data
   *
   * @return A 24 bit integer value
   */

  public static int unpackFromBytesBigEndian(
    final byte[] buffer)
  {
    NullCheck.notNull(buffer, "Buffer");
    if (buffer.length < 3) {
      throw new IllegalArgumentException(
        "Buffer.length must be >= 3 (is " + buffer.length + ")");
    }

    final int r0 = (buffer[0] << 16);
    final int r1 = (buffer[1] & 0xff) << 8;
    final int r2 = (buffer[2] & 0xff);
    final int r = r0 | r1 | r2;
    return r;
  }

  /**
   * <p>
   * Unpack an integer from {@code buffer} assuming a big-endian encoding
   * such that the most significant byte is in {@code b[index]}.
   * </p>
   *
   * @param index  The starting index in the buffer.
   * @param buffer The buffer from which to unpack data.
   *
   * @return A 24 bit integer value.
   */

  public static int unpackFromBufferBigEndian(
    final ByteBuffer buffer,
    final int index)
  {
    NullCheck.notNull(buffer, "Buffer");

    final int r0 = (buffer.get(index + 0) << 16);
    final int r1 = (buffer.get(index + 1) & 0xff) << 8;
    final int r2 = (buffer.get(index + 2) & 0xff);
    final int r = r0 | r1 | r2;
    return r;
  }

  /**
   * <p>
   * Unpack an integer from {@code buffer} using the encoding returned by
   * {@link ByteBuffer#order()}, starting at {@code index}.
   * </p>
   *
   * @param index  The starting index
   * @param buffer The buffer from which to unpack data.
   *
   * @return A 24 bit integer value.
   */

  public static int unpackFromBuffer(
    final ByteBuffer buffer,
    final int index)
  {
    NullCheck.notNull(buffer, "Buffer");

    if (buffer.order().equals(ByteOrder.BIG_ENDIAN)) {
      return unpackFromBufferBigEndian(buffer, index);
    }
    return unpackFromBufferLittleEndian(buffer, index);
  }

  /**
   * <p>
   * Unpack an integer from {@code buffer} assuming a little-endian
   * encoding such that the least significant byte is in {@code b[0]}.
   * </p>
   * <p>
   * The function throws {@link NullPointerException} if
   * {@code buffer == null} and {@link IllegalArgumentException} if
   * {@code buffer.length} is too small to contain a packed integer value
   * of this size.
   * </p>
   *
   * @param buffer The buffer from which to unpack data
   *
   * @return A 24 bit integer value
   */

  public static int unpackFromBytesLittleEndian(
    final byte[] buffer)
  {
    NullCheck.notNull(buffer, "Buffer");
    if (buffer.length < 3) {
      throw new IllegalArgumentException(
        "Buffer.length must be >= 3 (is " + buffer.length + ")");
    }

    final int r0 = (buffer[0] & 0xff);
    final int r1 = (buffer[1] & 0xff) << 8;
    final int r2 = buffer[2] << 16;
    final int r = r0 | r1 | r2;
    return r;
  }

  /**
   * <p>
   * Unpack an integer from {@code buffer} assuming a little-endian
   * encoding such that the least significant byte is in {@code b[index]}
   * .
   * </p>
   *
   * @param index  The starting index
   * @param buffer The buffer from which to unpack data.
   *
   * @return A 24 bit integer value.
   */

  public static int unpackFromBufferLittleEndian(
    final ByteBuffer buffer,
    final int index)
  {
    NullCheck.notNull(buffer, "Buffer");

    final int r0 = (buffer.get(index + 0) & 0xff);
    final int r1 = (buffer.get(index + 1) & 0xff) << 8;
    final int r2 = buffer.get(index + 2) << 16;
    final int r = r0 | r1 | r2;
    return r;
  }
}
