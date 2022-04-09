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

import com.io7m.jintegers.Signed64;

@SuppressWarnings({ "null", "static-method" }) public class Signed64Test
{
  @Test public void testIdentityBEInferred_BufferAll()
  {
    for (int k = 0; k < 64; ++k) {
      final long x = (long) (Math.pow(2, k) - 1);

      {
        final ByteBuffer b =
          ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        Signed64.packToBuffer(x, b, 0);
        final long y = Signed64.unpackFromBuffer(b, 0);
        Assert.assertEquals(x, y);
      }

      {
        final ByteBuffer b =
          ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        Signed64.packToBuffer(-x, b, 0);
        final long y = Signed64.unpackFromBuffer(b, 0);
        Assert.assertEquals(-x, y);
      }
    }
  }

  @Test public void testIdentityLEInferred_BufferAll()
  {
    for (int k = 0; k < 64; ++k) {
      final long x = (long) (Math.pow(2, k) - 1);

      {
        final ByteBuffer b =
          ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        Signed64.packToBuffer(x, b, 0);
        final long y = Signed64.unpackFromBuffer(b, 0);
        Assert.assertEquals(x, y);
      }

      {
        final ByteBuffer b =
          ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        Signed64.packToBuffer(-x, b, 0);
        final long y = Signed64.unpackFromBuffer(b, 0);
        Assert.assertEquals(-x, y);
      }
    }
  }

  @Test public void testIdentityBE_BufferAll()
  {
    for (int k = 0; k < 64; ++k) {
      final long x = (long) (Math.pow(2, k) - 1);

      {
        final ByteBuffer b = ByteBuffer.allocate(8);
        Signed64.packToBufferBigEndian(x, b, 0);
        final long y = Signed64.unpackFromBufferBigEndian(b, 0);
        Assert.assertEquals(x, y);
      }

      {
        final ByteBuffer b = ByteBuffer.allocate(8);
        Signed64.packToBufferBigEndian(-x, b, 0);
        final long y = Signed64.unpackFromBufferBigEndian(b, 0);
        Assert.assertEquals(-x, y);
      }
    }
  }

  @Test public void testIdentityLE_BufferAll()
  {
    for (int k = 0; k < 64; ++k) {
      final long x = (long) (Math.pow(2, k) - 1);

      {
        final ByteBuffer b = ByteBuffer.allocate(8);
        Signed64.packToBufferLittleEndian(x, b, 0);
        final long y = Signed64.unpackFromBufferLittleEndian(b, 0);
        System.out.printf("LE: (%d) %d %d\n", k, x, y);
        Assert.assertEquals(x, y);
      }

      {
        final ByteBuffer b = ByteBuffer.allocate(8);
        Signed64.packToBufferLittleEndian(-x, b, 0);
        final long y = Signed64.unpackFromBufferLittleEndian(b, 0);
        System.out.printf("LE: (%d) %d %d\n", k, x, y);
        Assert.assertEquals(-x, y);
      }
    }
  }

  @Test public void testIdentityBE_2pow16()
  {
    final int k = 16;
    final long x = (long) (Math.pow(2, k) - 1);

    {
      final byte[] b = Signed64.packToBytesBigEndianAllocate(x);
      final long y = Signed64.unpackFromBytesBigEndian(b);
      System.out.printf("BE: (%d) %d %d\n", k, x, y);
      Assert.assertEquals(x, y);
    }

    {
      final byte[] b = Signed64.packToBytesBigEndianAllocate(-x);
      final long y = Signed64.unpackFromBytesBigEndian(b);
      System.out.printf("BE: -(%d) %d %d\n", k, x, y);
      Assert.assertEquals(-x, y);
    }
  }

  @Test public void testIdentityBE_2pow23()
  {
    final int k = 23;
    final long x = (long) (Math.pow(2, k) - 1);

    {
      final byte[] b = Signed64.packToBytesBigEndianAllocate(x);
      final long y = Signed64.unpackFromBytesBigEndian(b);
      System.out.printf("BE: (%d) %d %d\n", k, x, y);
      Assert.assertEquals(x, y);
    }

    {
      final byte[] b = Signed64.packToBytesBigEndianAllocate(-x);
      final long y = Signed64.unpackFromBytesBigEndian(b);
      System.out.printf("BE: -(%d) %d %d\n", k, x, y);
      Assert.assertEquals(-x, y);
    }
  }

  @Test public void testIdentityBE_All()
  {
    for (int k = 0; k < 64; ++k) {
      final long x = (long) (Math.pow(2, k) - 1);

      {
        final byte[] b = Signed64.packToBytesBigEndianAllocate(x);
        final long y = Signed64.unpackFromBytesBigEndian(b);
        System.out.printf("BE: (%d) %d %d\n", k, x, y);
        Assert.assertEquals(x, y);
      }

      {
        final byte[] b = Signed64.packToBytesBigEndianAllocate(-x);
        final long y = Signed64.unpackFromBytesBigEndian(b);
        System.out.printf("BE: -(%d) %d %d\n", k, x, y);
        Assert.assertEquals(-x, y);
      }
    }
  }

  @Test public void testIdentityLE_All()
  {
    for (int k = 0; k < 64; ++k) {
      final long x = (long) (Math.pow(2, k) - 1);

      {
        final byte[] b = Signed64.packToBytesLittleEndianAllocate(x);
        final long y = Signed64.unpackFromBytesLittleEndian(b);
        System.out.printf("LE: (%d) %d %d\n", k, x, y);
        Assert.assertEquals(x, y);
      }

      {
        final byte[] b = Signed64.packToBytesLittleEndianAllocate(-x);
        final long y = Signed64.unpackFromBytesLittleEndian(b);
        System.out.printf("LE: (%d) %d %d\n", k, x, y);
        Assert.assertEquals(-x, y);
      }
    }
  }

  @Test(expected = IllegalArgumentException.class) public
    void
    testTooSmall_0()
  {
    Signed64.unpackFromBytesBigEndian(new byte[7]);
  }

  @Test(expected = IllegalArgumentException.class) public
    void
    testTooSmall_1()
  {
    Signed64.unpackFromBytesLittleEndian(new byte[7]);
  }

  @Test(expected = IllegalArgumentException.class) public
    void
    testTooSmall_2()
  {
    Signed64.packToBytesBigEndian(0, new byte[7]);
  }

  @Test(expected = IllegalArgumentException.class) public
    void
    testTooSmall_3()
  {
    Signed64.packToBytesLittleEndian(0, new byte[7]);
  }
}
