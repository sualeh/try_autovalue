package schemacrawler.model;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NamedObjectTest
{

  @Test
  public void testNamedObject()
  {
    AbstractNamedObjectWithAttributes dog = AbstractNamedObjectWithAttributes
      .builder().setName("dog").setRemarks("Good dog").build();

    assertEquals("dog", dog.getName());
    assertEquals("Good dog", dog.getRemarks());
  }

}
