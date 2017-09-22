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

/**
 * Table constraint type.
 */
public enum TableConstraintType
  implements
  ConstraintType
{

 unknown("unknown"),
 primary_key("PRIMARY KEY"),
 foreign_key("FOREIGN KEY"),
 unique("UNIQUE"),
 check("CHECK"),;

  /**
   * Find the enumeration value corresponding to the string.
   *
   * @param value
   *        Sort sequence code.
   * @return Enumeration value
   */
  public static TableConstraintType valueOfFromValue(final String value)
  {
    for (final TableConstraintType type: TableConstraintType.values())
    {
      if (type.getValue().equalsIgnoreCase(value))
      {
        return type;
      }
    }
    return unknown;
  }

  private final String value;

  private TableConstraintType(final String value)
  {
    this.value = value;
  }

  /**
   * Gets the value.
   *
   * @return Value
   */
  @Override
  public final String getValue()
  {
    return value;
  }

}
