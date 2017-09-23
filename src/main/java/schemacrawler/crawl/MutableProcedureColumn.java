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


import schemacrawler.schema.Procedure;
import schemacrawler.schema.ProcedureColumn;
import schemacrawler.schema.ProcedureColumnType;

/**
 * Represents a column in a database procedure. Created from metadata
 * returned by a JDBC call.
 *
 * @author Sualeh Fatehi
 */
final class MutableProcedureColumn
  extends MutableRoutineColumn<Procedure>
  implements ProcedureColumn
{

  private static final long serialVersionUID = 3546361725629772857L;

  private ProcedureColumnType procedureColumnType;

  MutableProcedureColumn(final Procedure parent, final String name)
  {
    super(new ProcedureReference(parent), name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ProcedureColumnType getColumnType()
  {
    return procedureColumnType;
  }

  void setProcedureColumnType(final ProcedureColumnType procedureColumnType)
  {
    this.procedureColumnType = procedureColumnType;
  }

}
