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
 * Unsigned 16-bit integer handling.
 */

public final class Unsigned16
{
  private Unsigned16()
  {
    throw new UnreachableCodeException();
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

    final short x = (short) i;
    r.put(index + 0, (byte) (x >> 8));
    r.put(index + 1, (byte) (x & 0xff));
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

    final short x = (short) i;
    r.put(index + 0, (byte) (x & 0xff));
    r.put(index + 1, (byte) (x >> 8));
    return r;
  }

  /**
   * Pack an unsigned 16-bit integer into the buffer.
   *
   * @param x     The value.
   * @param data  The buffer.
   * @param index The starting index.
   */

  public static void packToBuffer(
    final int x,
    final ByteBuffer data,
    final int index)
  {
    NullCheck.notNull(data, "Buffer");

    if (data.order().equals(ByteOrder.BIG_ENDIAN)) {
      packToBufferBigEndian(x, data, index);
    } else {
      packToBufferLittleEndian(x, data, index);
    }
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
   * @return A 16 bit integer value.
   */

  public static int unpackFromBufferBigEndian(
    final ByteBuffer buffer,
    final int index)
  {
    NullCheck.notNull(buffer, "Buffer");

    final int b0 = (buffer.get(index + 0) & 0xff) << 8;
    final int b1 = buffer.get(index + 1) & 0xff;
    return b0 | b1;
  }

  /**
   * Unpack an unsigned 16-bit integer from the buffer.
   *
   * @param data  The buffer.
   * @param index The starting index.
   *
   * @return An unpacked integer value.
   */

  public static int unpackFromBuffer(
    final ByteBuffer data,
    final int index)
  {
    NullCheck.notNull(data, "Buffer");

    if (data.order().equals(ByteOrder.BIG_ENDIAN)) {
      return unpackFromBufferBigEndian(data, index);
    }
    return unpackFromBufferLittleEndian(data, index);
  }

  /**
   * <p>
   * Unpack an integer from {@code buffer} assuming a little-endian
   * encoding such that the least significant byte is in {@code b[index]}.
   * </p>
   *
   * @param index  The starting index
   * @param buffer The buffer from which to unpack data.
   *
   * @return A 16 bit integer value.
   */

  public static int unpackFromBufferLittleEndian(
    final ByteBuffer buffer,
    final int index)
  {
    NullCheck.notNull(buffer, "Buffer");

    final int b0 = buffer.get(index + 0) & 0xff;
    final int b1 = (buffer.get(index + 1) & 0xff) << 8;
    return b0 | b1;
  }
}
