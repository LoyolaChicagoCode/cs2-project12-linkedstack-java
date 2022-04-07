package edu.luc.cs271.linkedstack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class TestLinkedStack {

  private IStack<String> fixture;

  @Before
  public void setUp() {
    fixture = new LinkedStack<>();
  }

  @After
  public void tearDown() {
    fixture = null;
  }

  @Test
  public void testInitialPop() {
    assertTrue(fixture.isEmpty());
    fixture.pop();
  }

  @Test(expected = NoSuchElementException.class)
  public void testInitialPeek() {
    assertTrue(fixture.isEmpty());
    fixture.peek();
  }

  @Test
  public void testAfterPush() {
    final var value = "hello";
    fixture.push(value);
    assertFalse(fixture.isEmpty());
    assertEquals(value, fixture.peek());
  }

  @Test
  public void testPushThenPop() {
    final var value = "hello";
    fixture.push(value);
    assertEquals(value, fixture.pop());
    assertTrue(fixture.isEmpty());
  }

  @Test
  public void testPush2ThenPop2() {
    final var value1 = "hello";
    final var value2 = "world";
    fixture.push(value1);
    fixture.push(value2);
    assertEquals(value2, fixture.pop());
    assertEquals(value1, fixture.pop());
    assertTrue(fixture.isEmpty());
  }

  @Test
  public void testAsListEmpty() {
    assertEquals(0, fixture.asList().size());
  }

  @Test
  public void testAsListNonempty() {
    final var value1 = "hello";
    final var value2 = "world";
    fixture.push(value1);
    fixture.push(value2);
    final List<String> list = fixture.asList();
    assertEquals(2, list.size());
    assertEquals(Arrays.asList(value2, value1), list);
    final List<String> list2 = fixture.asList();
    assertEquals(2, list2.size());
  }
}
