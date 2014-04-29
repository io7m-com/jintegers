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

package com.io7m.jintegers.tests;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jintegers.Integer32;

@SuppressWarnings({ "null", "static-method" }) public class Integer32Test
{
  @Test public void testBufferIdentityBE_0()
  {
    final int x = 0;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    Integer32.packBigEndianToBuffer(x, buffer, 0);
    final int y = Integer32.unpackBigEndianFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testBufferIdentityBE_0x7fffffff()
  {
    final int x = 0x7fffffff;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    Integer32.packBigEndianToBuffer(x, buffer, 0);
    final int y = Integer32.unpackBigEndianFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testBufferIdentityBE_0xffff()
  {
    final int x = 0xffff;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    Integer32.packBigEndianToBuffer(x, buffer, 0);
    final int y = Integer32.unpackBigEndianFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testBufferIdentityBE_0xffffffff()
  {
    final int x = 0xffffffff;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    Integer32.packBigEndianToBuffer(x, buffer, 0);
    final int y = Integer32.unpackBigEndianFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testBufferIdentityBEInferred_0x7fffffff()
  {
    final int x = 0x7fffffff;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    buffer.order(ByteOrder.BIG_ENDIAN);
    Integer32.packToBuffer(x, buffer, 0);
    final int y = Integer32.unpackFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testBufferIdentityLE_0()
  {
    final int x = 0;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    Integer32.packLittleEndianToBuffer(x, buffer, 0);
    final int y = Integer32.unpackLittleEndianFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testBufferIdentityLE_0x7fffffff()
  {
    final int x = 0x7fffffff;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    Integer32.packLittleEndianToBuffer(x, buffer, 0);
    final int y = Integer32.unpackLittleEndianFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testBufferIdentityLE_0xffff()
  {
    final int x = 0xffff;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    Integer32.packLittleEndianToBuffer(x, buffer, 0);
    final int y = Integer32.unpackLittleEndianFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testBufferIdentityLE_0xffffffff()
  {
    final int x = 0xffffffff;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    Integer32.packLittleEndianToBuffer(x, buffer, 0);
    final int y = Integer32.unpackLittleEndianFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testBufferIdentityLEInferred_0x7fffffff()
  {
    final int x = 0x7fffffff;
    final ByteBuffer buffer = ByteBuffer.allocate(4);
    buffer.order(ByteOrder.LITTLE_ENDIAN);
    Integer32.packToBuffer(x, buffer, 0);
    final int y = Integer32.unpackFromBuffer(buffer, 0);
    Assert.assertEquals(x, y);
  }

  @Test public void testIdentityBE_0()
  {
    final int x = 0;
    final byte[] b = Integer32.packBigEndian(x);
    final int y = Integer32.unpackBigEndian(b);
    Assert.assertEquals(x, y);
  }

  @Test public void testIdentityBE_0x7fffffff()
  {
    final int x = 0x7fffffff;
    final byte[] b = Integer32.packBigEndian(x);
    final int y = Integer32.unpackBigEndian(b);
    Assert.assertEquals(x, y);
  }

  @Test public void testIdentityBE_0xffff()
  {
    final int x = 0xffff;
    final byte[] b = Integer32.packBigEndian(x);
    final int y = Integer32.unpackBigEndian(b);
    Assert.assertEquals(x, y);
  }

  @Test public void testIdentityBE_0xffffffff()
  {
    final int x = 0xffffffff;
    final byte[] b = Integer32.packBigEndian(x);
    final int y = Integer32.unpackBigEndian(b);
    Assert.assertEquals(x, y);
  }

  @Test public void testIdentityLE_0()
  {
    final int x = 0;
    final byte[] b = Integer32.packLittleEndian(x);
    final int y = Integer32.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }

  @Test public void testIdentityLE_0x7fffffff()
  {
    final int x = 0x7fffffff;
    final byte[] b = Integer32.packLittleEndian(x);
    final int y = Integer32.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }

  @Test public void testIdentityLE_0xffff()
  {
    final int x = 0xffff;
    final byte[] b = Integer32.packLittleEndian(x);
    final int y = Integer32.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }

  @Test public void testIdentityLE_0xffffffff()
  {
    final int x = 0xffffffff;
    final byte[] b = Integer32.packLittleEndian(x);
    final int y = Integer32.unpackLittleEndian(b);
    Assert.assertEquals(x, y);
  }

  @Test(expected = IllegalArgumentException.class) public
    void
    testTooSmall_0()
  {
    Integer32.unpackBigEndian(new byte[3]);
  }

  @Test(expected = IllegalArgumentException.class) public
    void
    testTooSmall_1()
  {
    Integer32.unpackLittleEndian(new byte[3]);
  }

  @Test(expected = IllegalArgumentException.class) public
    void
    testTooSmall_2()
  {
    Integer32.packBigEndianTo(0, new byte[3]);
  }

  @Test(expected = IllegalArgumentException.class) public
    void
    testTooSmall_3()
  {
    Integer32.packLittleEndianTo(0, new byte[3]);
  }
}
