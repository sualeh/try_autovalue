package schemacrawler.model;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import schemacrawler.schema.NamedObject;

public class NamedObjectTest
{

  @Test
  public void testNamedObject()
  {
    NamedObject dog = AbstractNamedObject.builder().setName("dog").build();
    assertEquals("dog", dog.getName());
  }

}
