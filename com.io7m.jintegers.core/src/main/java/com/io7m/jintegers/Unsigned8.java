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

import java.util.Objects;
import com.io7m.junreachable.UnreachableCodeException;

import java.nio.ByteBuffer;

/**
 * Unsigned 8-bit integer handling.
 */

public final class Unsigned8
{
  private Unsigned8()
  {
    throw new UnreachableCodeException();
  }

  /**
   * Unpack an unsigned 8-bit integer from the buffer.
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
    Objects.requireNonNull(data, "Buffer");
    final int x = data.get(index);
    return (x & 0xff);
  }

  /**
   * Pack an unsigned 8-bit integer into the buffer.
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
    Objects.requireNonNull(data, "Buffer");
    data.put(index, (byte) (x & 0xff));
  }
}
