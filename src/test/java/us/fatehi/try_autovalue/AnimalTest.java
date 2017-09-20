package us.fatehi.try_autovalue;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnimalTest
{

  @Test
  public void testAnimal()
  {
    Animal dog = Animal.create("dog", 4);
    assertEquals("dog", dog.name());
    assertEquals(4, dog.numberOfLegs());

    // You probably don't need to write assertions like these; just
    // illustrating.
    assertTrue(Animal.create("dog", 4).equals(dog));
    assertFalse(Animal.create("cat", 4).equals(dog));
    assertFalse(Animal.create("dog", 2).equals(dog));

    assertEquals("Animal{name=dog, numberOfLegs=4}", dog.toString());
  }

}
