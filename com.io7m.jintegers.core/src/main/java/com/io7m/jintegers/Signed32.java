/*
 * Copyright © 2014 Mark Raynsford <code@io7m.com> https://www.io7m.com
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

import java.util.Objects;
import com.io7m.junreachable.UnreachableCodeException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 32-bit integer packing/unpacking functions.
 */

public final class Signed32
{
  private Signed32()
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
    final byte[] r = new byte[4];
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
   * @return A byte buffer containing the packed integer data.
   */

  public static byte[] packToBytesBigEndian(
    final int i,
    final byte[] r)
  {
    Objects.requireNonNull(r, "Buffer");
    if (r.length < 4) {
      throw new IllegalArgumentException(
        "Buffer.length must be >= 4 (is " + r.length + ")");
    }

    int x = i;
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
    Objects.requireNonNull(r, "Buffer");

    int x = i;
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
    final byte[] r = new byte[4];
    return packToBytesLittleEndian(i, r);
  }

  /**
   * <p>
   * Pack {@code i} into a byte buffer {@code r} using a
   * little-endian encoding such that the least significant byte is in
   * {@code r[0]}.
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
    Objects.requireNonNull(r, "Buffer");
    if (r.length < 4) {
      throw new IllegalArgumentException(
        "Buffer.length must be >= 4 (is " + r.length + ")");
    }

    int x = i;
    r[0] = (byte) (x & 0xff);
    x >>= 8;
    r[1] = (byte) (x & 0xff);
    x >>= 8;
    r[2] = (byte) (x & 0xff);
    x >>= 8;
    r[3] = (byte) (x & 0xff);
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
    Objects.requireNonNull(r, "Buffer");

    int x = i;
    r.put(index + 0, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 1, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 2, (byte) (x & 0xff));
    x >>= 8;
    r.put(index + 3, (byte) (x & 0xff));
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
    Objects.requireNonNull(r, "Buffer");

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
   * @return A 32 bit integer value
   */

  public static int unpackFromBytesBigEndian(
    final byte[] buffer)
  {
    Objects.requireNonNull(buffer, "Buffer");
    if (buffer.length < 4) {
      throw new IllegalArgumentException(
        "Buffer.length must be >= 4 (is " + buffer.length + ")");
    }

    int r = 0;
    r |= buffer[0] & 0xFF;
    r <<= 8;
    r |= buffer[1] & 0xFF;
    r <<= 8;
    r |= buffer[2] & 0xFF;
    r <<= 8;
    r |= buffer[3] & 0xFF;
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
   * @return A 32 bit integer value.
   */

  public static int unpackFromBufferBigEndian(
    final ByteBuffer buffer,
    final int index)
  {
    Objects.requireNonNull(buffer, "Buffer");

    int r = (buffer.get(index) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 1) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 2) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 3) & 0xff);
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
   * @return A 32 bit integer value.
   */

  public static int unpackFromBuffer(
    final ByteBuffer buffer,
    final int index)
  {
    Objects.requireNonNull(buffer, "Buffer");

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
   * @return A 32 bit integer value
   */

  public static int unpackFromBytesLittleEndian(
    final byte[] buffer)
  {
    Objects.requireNonNull(buffer, "Buffer");
    if (buffer.length < 4) {
      throw new IllegalArgumentException(
        "Buffer.length must be >= 4 (is " + buffer.length + ")");
    }

    int r = 0;
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
   * Unpack an integer from {@code buffer} assuming a little-endian
   * encoding such that the least significant byte is in {@code b[index]}
   * .
   * </p>
   *
   * @param index  The starting index
   * @param buffer The buffer from which to unpack data.
   *
   * @return A 32 bit integer value.
   */

  public static int unpackFromBufferLittleEndian(
    final ByteBuffer buffer,
    final int index)
  {
    Objects.requireNonNull(buffer, "Buffer");

    int r = (buffer.get(index + 3) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 2) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 1) & 0xff);
    r <<= 8;
    r += (buffer.get(index + 0) & 0xff);
    return r;
  }
}
