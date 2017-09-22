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

package schemacrawler.schema;


import java.util.List;
import java.util.Optional;

/**
 * Represents an index on a database table.
 *
 * @author Sualeh Fatehi
 */
public interface Index
  extends DependantObject<Table>, TypedObject<IndexType>, DefinedObject,
  Iterable<IndexColumn>
{

  /**
   * Gets the cardinality. When the index type is statistic, then this
   * is the number of rows in the table; otherwise, it is the number of
   * unique values in the index.
   *
   * @return Cardinality
   */
  int getCardinality();

  /**
   * Gets the list of columns in ordinal order.
   *
   * @return Columns of the index.
   */
  List<IndexColumn> getColumns();

  /**
   * Gets the index type.
   *
   * @return Index type.
   */
  IndexType getIndexType();

  /**
   * Gets the pages. When the index type is statistic, then this is the
   * number of pages used for the table, otherwise it is the number of
   * pages used for the current index.
   *
   * @return Pages
   */
  int getPages();

  /**
   * If the index is unique.
   *
   * @return If the index is unique
   */
  boolean isUnique();

  /**
   * Gets a column by unqualified name.
   *
   * @param name
   *        Unqualified name
   * @return Column.
   */
  Optional<? extends IndexColumn> lookupColumn(String name);

}
