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

package com.io7m.jintegers.tests;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jintegers.Unsigned32;

@SuppressWarnings({ "boxing", "static-method" }) public final class Unsigned32Test
{
  @Test public void testBE_32()
  {
    final ByteBuffer b = ByteBuffer.allocate(4);
    b.order(ByteOrder.BIG_ENDIAN);

    b.put(0, (byte) 0xff);
    b.put(1, (byte) 0xff);
    b.put(2, (byte) 0xff);
    b.put(3, (byte) 0xff);

    final long x = 0xffffffffL;
    final long y = Unsigned32.unpackFromBuffer(b, 0);
    System.out.printf("%d %d\n", x, y);
    Assert.assertEquals(x, y);
  }

  @Test public void testBE()
  {
    final ByteBuffer b = ByteBuffer.allocate(4);
    b.order(ByteOrder.BIG_ENDIAN);

    for (int i = 0; i <= 32; ++i) {
      final long x = (long) Math.pow(2, i) - 1;
      Unsigned32.packToBuffer((int) x, b, 0);
      final long y = Unsigned32.unpackFromBuffer(b, 0);
      System.out.printf("%d %d\n", x, y);
      Assert.assertEquals(x, y);
    }
  }

  @Test public void testLE_32()
  {
    final ByteBuffer b = ByteBuffer.allocate(4);
    b.order(ByteOrder.LITTLE_ENDIAN);

    b.put(0, (byte) 0xff);
    b.put(1, (byte) 0xff);
    b.put(2, (byte) 0xff);
    b.put(3, (byte) 0xff);

    final long x = 0xffffffffL;
    final long y = Unsigned32.unpackFromBuffer(b, 0);
    System.out.printf("%d %d\n", x, y);
    Assert.assertEquals(x, y);
  }

  @Test public void testLE()
  {
    final ByteBuffer b = ByteBuffer.allocate(4);
    b.order(ByteOrder.LITTLE_ENDIAN);

    for (int i = 0; i <= 32; ++i) {
      final long x = (long) Math.pow(2, i) - 1;
      Unsigned32.packToBuffer((int) x, b, 0);
      final long y = Unsigned32.unpackFromBuffer(b, 0);
      System.out.printf("%d %d\n", x, y);
      Assert.assertEquals(x, y);
    }
  }
}
