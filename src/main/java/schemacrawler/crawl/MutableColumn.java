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


import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import schemacrawler.schema.Column;
import schemacrawler.schema.Privilege;
import schemacrawler.schema.Table;

/**
 * Represents a column in a database table or routine. Created from
 * metadata returned by a JDBC call.
 *
 * @author Sualeh Fatehi
 */
class MutableColumn
  extends AbstractColumn<Table>
  implements Column
{

  private static final long serialVersionUID = 3834591019449528633L;

  private String defaultValue;
  private boolean isAutoIncremented;
  private boolean isGenerated;
  private boolean isHidden;
  private boolean isPartOfPrimaryKey;
  private boolean isPartOfUniqueIndex;
  private boolean isPartOfIndex;
  private Column referencedColumn;
  private final NamedObjectList<MutablePrivilege<Column>> privileges = new NamedObjectList<>();

  MutableColumn(final Table parent, final String name)
  {
    super(new TableReference(parent), name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDefaultValue()
  {
    return defaultValue;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Privilege<Column>> getPrivileges()
  {
    return new ArrayList<Privilege<Column>>(privileges.values());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Column getReferencedColumn()
  {
    return referencedColumn;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isAutoIncremented()
  {
    return isAutoIncremented;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isGenerated()
  {
    return isGenerated;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isHidden()
  {
    return isHidden;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isPartOfForeignKey()
  {
    return referencedColumn != null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isPartOfIndex()
  {
    return isPartOfIndex;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isPartOfPrimaryKey()
  {
    return isPartOfPrimaryKey;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isPartOfUniqueIndex()
  {
    return isPartOfUniqueIndex;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<MutablePrivilege<Column>> lookupPrivilege(final String name)
  {
    return privileges.lookup(this, name);
  }

  void addPrivilege(final MutablePrivilege<Column> privilege)
  {
    privileges.add(privilege);
  }

  void markAsPartOfIndex()
  {
    isPartOfIndex = true;
  }

  void markAsPartOfPrimaryKey()
  {
    isPartOfPrimaryKey = true;
  }

  void markAsPartOfUniqueIndex()
  {
    isPartOfUniqueIndex = true;
  }

  void setAutoIncremented(final boolean isAutoIncremented)
  {
    this.isAutoIncremented = isAutoIncremented;
  }

  void setDefaultValue(final String defaultValue)
  {
    this.defaultValue = defaultValue;
  }

  void setGenerated(final boolean isGenerated)
  {
    this.isGenerated = isGenerated;
  }

  void setHidden(final boolean isHidden)
  {
    this.isHidden = isHidden;
  }

  void setReferencedColumn(final Column referencedColumn)
  {
    this.referencedColumn = referencedColumn;
  }

}
