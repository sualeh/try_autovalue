package schemacrawler.model;


import schemacrawler.schema.NamedObject;
import schemacrawler.utility.NamedObjectSort;

/**
 * Represents a named object.
 *
 * @author Sualeh Fatehi
 */
public abstract class AbstractNamedObject
  implements NamedObject
{

  private static final long serialVersionUID = -1486322887991472729L;

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo(final NamedObject obj)
  {
    if (obj == null)
    {
      return -1;
    }

    return NamedObjectSort.alphabetical.compare(this, obj);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getFullName()
  {
    return getName();
  }

  @Override
  public String getLookupKey()
  {
    return getFullName();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public abstract String getName();

  /**
   * {@inheritDoc}
   */
  @Override
  public final String toString()
  {
    return getFullName();
  }

}
