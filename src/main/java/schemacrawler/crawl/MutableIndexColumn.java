/*
========================================================================
SchemaCrawler
http://www.schemacrawler.com
Copyright (c) 2000-2017, Sualeh Fatehi <sualeh@hotmail.com>.
All rights reserved.
------------------------------------------------------------------------

SchemaCrawler is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

SchemaCrawler and the accompanying materials are made available under
the terms of the Eclipse Public License v1.0, GNU General Public License
v3 or GNU Lesser General Public License v3.

You may elect to redistribute this code under any of these licenses.

The Eclipse Public License is available at:
http://www.eclipse.org/legal/epl-v10.html

The GNU General Public License v3 and the GNU Lesser General Public
License v3 are available at:
http://www.gnu.org/licenses/

========================================================================
*/
package schemacrawler.crawl;


import java.util.Collection;
import java.util.Optional;

import schemacrawler.schema.Column;
import schemacrawler.schema.ColumnDataType;
import schemacrawler.schema.Index;
import schemacrawler.schema.IndexColumn;
import schemacrawler.schema.IndexColumnSortSequence;
import schemacrawler.schema.NamedObject;
import schemacrawler.schema.Privilege;
import schemacrawler.schema.Table;

final class MutableIndexColumn
  extends AbstractDependantObject<Table>
  implements IndexColumn
{

  private static final long serialVersionUID = -6923211341742623556L;

  private final Column column;
  private final Index index;
  private int indexOrdinalPosition;
  private IndexColumnSortSequence sortSequence;
  private final StringBuilder definition;

  MutableIndexColumn(final Index index, final Column column)
  {
    super(new TableReference(column.getParent()), column.getName());
    this.index = index;
    this.column = column;
    definition = new StringBuilder();
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

    int comparison = 0;

    if (obj instanceof MutableIndexColumn)
    {
      final MutableIndexColumn other = (MutableIndexColumn) obj;
      comparison = indexOrdinalPosition - other.indexOrdinalPosition;
    }

    if (comparison == 0)
    {
      comparison = super.compareTo(obj);
    }

    return comparison;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ColumnDataType getColumnDataType()
  {
    return column.getColumnDataType();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getDecimalDigits()
  {
    return column.getDecimalDigits();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDefaultValue()
  {
    return column.getDefaultValue();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDefinition()
  {
    return definition.toString();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Index getIndex()
  {
    return index;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getIndexOrdinalPosition()
  {
    return indexOrdinalPosition;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getOrdinalPosition()
  {
    return column.getOrdinalPosition();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Privilege<Column>> getPrivileges()
  {
    return column.getPrivileges();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Column getReferencedColumn()
  {
    return column.getReferencedColumn();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getSize()
  {
    return column.getSize();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IndexColumnSortSequence getSortSequence()
  {
    return sortSequence;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ColumnDataType getType()
  {
    return column.getType();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getWidth()
  {
    return column.getWidth();
  }

  @Override
  public boolean hasDefinition()
  {
    return definition.length() > 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isAutoIncremented()
  {
    return column.isAutoIncremented();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isGenerated()
  {
    return column.isGenerated();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isHidden()
  {
    return column.isHidden();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isNullable()
  {
    return column.isNullable();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isPartOfForeignKey()
  {
    return column.isPartOfForeignKey();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isPartOfIndex()
  {
    return column.isPartOfIndex();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isPartOfPrimaryKey()
  {
    return column.isPartOfPrimaryKey();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isPartOfUniqueIndex()
  {
    return column.isPartOfUniqueIndex();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<? extends Privilege<Column>> lookupPrivilege(final String name)
  {
    return column.lookupPrivilege(name);
  }

  void appendDefinition(final String definition)
  {
    if (definition != null)
    {
      this.definition.append(definition);
    }
  }

  void setIndexOrdinalPosition(final int indexOrdinalPosition)
  {
    this.indexOrdinalPosition = indexOrdinalPosition;
  }

  void setSortSequence(final IndexColumnSortSequence sortSequence)
  {
    this.sortSequence = sortSequence;
  }

}
