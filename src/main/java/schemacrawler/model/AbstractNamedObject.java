package schemacrawler.model;


import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.memoized.Memoized;

import schemacrawler.schema.NamedObject;
import schemacrawler.utility.NamedObjectSort;

/**
 * Represents a named object.
 *
 * @author Sualeh Fatehi
 */
@AutoValue
abstract class AbstractNamedObject
  implements NamedObject
{

  @AutoValue.Builder
  abstract static class Builder
  {
    abstract AbstractNamedObject build();

    abstract Builder setName(String name);
  }

  private static final long serialVersionUID = -1486322887991472729L;

  public static Builder builder()
  {
    return new AutoValue_AbstractNamedObject.Builder();
  }

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
  @Memoized
  public String getFullName()
  {
    return getName();
  }

  @Override
  @Memoized
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
