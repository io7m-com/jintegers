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

/**
 * 24-bit integer packing/unpacking functions.
 */

public final class Integer24
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
    final int i)
  {
    final byte[] r = new byte[3];
    int x = i;

    r[2] = (byte) (x & 0xff);
    x >>= 8;
    r[1] = (byte) (x & 0xff);
    x >>= 8;
    r[0] = (byte) (x & 0xff);

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
    final int i)
  {
    final byte[] r = new byte[3];
    int x = i;

    r[0] = (byte) (x & 0xff);
    x >>= 8;
    r[1] = (byte) (x & 0xff);
    x >>= 8;
    r[2] = (byte) (x & 0xff);

    return r;
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
   * @return A 24 bit integer value
   */

  public static int unpackBigEndian(
    final byte[] buffer)
  {
    NullCheck.notNull(buffer, "Buffer");
    if (buffer.length < 3) {
      throw new IllegalArgumentException("Buffer.length must be >= 3 (is "
        + buffer.length
        + ")");
    }

    int r = 0;

    r |= buffer[0] & 0xFF;
    r <<= 8;
    r |= buffer[1] & 0xFF;
    r <<= 8;
    r |= buffer[2] & 0xFF;

    return r;
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
   * @return A 24 bit integer value
   */

  public static int unpackLittleEndian(
    final byte[] buffer)
  {
    NullCheck.notNull(buffer, "Buffer");
    if (buffer.length < 3) {
      throw new IllegalArgumentException("Buffer.length must be >= 3 (is "
        + buffer.length
        + ")");
    }

    int r = 0;

    r |= buffer[2] & 0xFF;
    r <<= 8;
    r |= buffer[1] & 0xFF;
    r <<= 8;
    r |= buffer[0] & 0xFF;

    return r;
  }

  private Integer24()
  {
    throw new UnreachableCodeException();
  }
}
