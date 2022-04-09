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

import com.io7m.jintegers.Unsigned16;

@SuppressWarnings({ "null", "static-method" }) public class Unsigned16Test
{
  @Test public void testIdentityBEInferred_BufferAll()
  {
    for (int x = 0; x <= 0xffff; ++x) {
      final ByteBuffer b = ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN);
      Unsigned16.packToBuffer(x, b, 0);
      final int y = Unsigned16.unpackFromBuffer(b, 0);
      Assert.assertEquals(x, y);
    }
  }

  @Test public void testIdentityLEInferred_BufferAll()
  {
    for (int x = 0; x <= 0xffff; ++x) {
      final ByteBuffer b =
        ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
      Unsigned16.packToBuffer(x, b, 0);
      final int y = Unsigned16.unpackFromBuffer(b, 0);
      Assert.assertEquals(x, y);
    }
  }

  @Test public void testIdentityBE_BufferAll()
  {
    for (int x = 0; x <= 0xffff; ++x) {
      final ByteBuffer b = ByteBuffer.allocate(2);
      Unsigned16.packToBufferBigEndian(x, b, 0);
      final int y = Unsigned16.unpackFromBufferBigEndian(b, 0);
      Assert.assertEquals(x, y);
    }
  }

  @Test public void testIdentityLE_BufferAll()
  {
    for (int x = 0; x <= 0xffff; ++x) {
      final ByteBuffer b = ByteBuffer.allocate(2);
      Unsigned16.packToBufferLittleEndian(x, b, 0);
      final int y = Unsigned16.unpackFromBufferLittleEndian(b, 0);
      Assert.assertEquals(x, y);
    }
  }
}
