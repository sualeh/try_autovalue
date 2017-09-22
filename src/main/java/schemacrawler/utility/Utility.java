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
package schemacrawler.utility;


import static java.util.Objects.requireNonNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import schemacrawler.schema.IdentifiedEnum;

/**
 * Utility methods.
 *
 * @author Sualeh Fatehi
 */
public final class Utility
{

  public static String convertForComparison(final String text)
  {
    if (text == null || text.length() == 0)
    {
      return text;
    }

    final StringBuilder builder = new StringBuilder(text.length());
    for (int i = 0; i < text.length(); i++)
    {
      final char ch = text.charAt(i);
      if (Character.isLetterOrDigit(ch) || ch == '_' || ch == '.')
      {
        builder.append(Character.toLowerCase(ch));
      }
    }

    final String textWithoutQuotes = builder.toString();
    return textWithoutQuotes;
  }

  /**
   * Checks if the text is null or empty.
   *
   * @param text
   *        Text to check.
   * @return Whether the string is blank.
   */
  public static boolean isBlank(final CharSequence text)
  {
    if (text == null || text.length() == 0)
    {
      return true;
    }

    for (int i = 0; i < text.length(); i++)
    {
      if (!Character.isWhitespace(text.charAt(i)))
      {
        return false;
      }
    }
    return true;
  }

  private Utility()
  {
    // Prevent instantiation
  }

}
