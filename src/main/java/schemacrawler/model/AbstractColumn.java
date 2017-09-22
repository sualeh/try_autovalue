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

package schemacrawler.model;


import schemacrawler.schema.BaseColumn;
import schemacrawler.schema.ColumnDataType;
import schemacrawler.schema.DatabaseObject;
import schemacrawler.schema.JavaSqlType.JavaSqlTypeGroup;
import schemacrawler.schema.NamedObject;

/**
 * Represents a column in a database for tables and routines. Created
 * from metadata returned by a JDBC call.
 *
 * @author Sualeh Fatehi
 */
abstract class AbstractColumn<P extends DatabaseObject>
  extends AbstractDependantObject<P>
  implements BaseColumn<P>
{

  private static final long serialVersionUID = -8492662324895309485L;

  private ColumnDataType columnDataType;
  private int ordinalPosition;
  private int size;
  private int decimalDigits;
  private boolean nullable;

  AbstractColumn(final DatabaseObjectReference<P> parent, final String name)
  {
    super(parent, name);
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

    final BaseColumn<P> other = (BaseColumn<P>) obj;
    int comparison = 0;

    if (comparison == 0)
    {
      comparison = ordinalPosition - other.getOrdinalPosition();
    }
    if (comparison == 0)
    {
      comparison = super.compareTo(other);
    }

    return comparison;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final ColumnDataType getColumnDataType()
  {
    return columnDataType;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final int getDecimalDigits()
  {
    return decimalDigits;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final int getOrdinalPosition()
  {
    return ordinalPosition;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final int getSize()
  {
    return size;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final ColumnDataType getType()
  {
    return getColumnDataType();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final String getWidth()
  {

    final ColumnDataType columnDataType = getColumnDataType();
    if (columnDataType == null)
    {
      return "";
    }

    if (size <= 0 || size >= 2_000_000_000)
    {
      return "";
    }

    final JavaSqlTypeGroup sqlDataTypeGroup = columnDataType.getJavaSqlType()
      .getJavaSqlTypeGroup();
    final boolean needWidth = sqlDataTypeGroup == JavaSqlTypeGroup.character
                              || sqlDataTypeGroup == JavaSqlTypeGroup.real;

    final StringBuilder columnWidthBuffer = new StringBuilder(64);
    if (needWidth)
    {
      columnWidthBuffer.append('(');
      columnWidthBuffer.append(size);
      if (sqlDataTypeGroup == JavaSqlTypeGroup.real)
      {
        columnWidthBuffer.append(", ").append(getDecimalDigits());
      }
      columnWidthBuffer.append(')');
    }

    return columnWidthBuffer.toString();

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final boolean isNullable()
  {
    return nullable;
  }

  void setColumnDataType(final ColumnDataType columnDataType)
  {
    this.columnDataType = columnDataType;
  }

  final void setDecimalDigits(final int decimalDigits)
  {
    this.decimalDigits = decimalDigits;
  }

  final void setNullable(final boolean nullable)
  {
    this.nullable = nullable;
  }

  final void setOrdinalPosition(final int ordinalPosition)
  {
    this.ordinalPosition = ordinalPosition;
  }

  /**
   * Sets the column size.
   *
   * @param size
   *        Size of the column
   */
  final void setSize(final int size)
  {
    this.size = size;
  }

}
