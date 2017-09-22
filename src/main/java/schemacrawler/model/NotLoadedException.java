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


import schemacrawler.schema.Constraint;
import schemacrawler.schema.PartialDatabaseObject;

public class NotLoadedException
  extends UnsupportedOperationException
{

  private static final long serialVersionUID = -1745422469189598709L;

  public NotLoadedException(final Constraint constraint)
  {
    super(String.format(
                        "Complete metadata has not been loaded for table constraint <%s>",
                        constraint));
  }

  public NotLoadedException(final PartialDatabaseObject databaseObject)
  {
    super(String.format("Complete metadata has not been loaded for <%s>",
                        databaseObject));
  }

}