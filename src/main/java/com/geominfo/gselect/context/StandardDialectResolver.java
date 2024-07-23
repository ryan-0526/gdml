/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package com.geominfo.gselect.context;

import com.geominfo.gselect.dialect.Dialect;

/**
 * The standard DialectResolver implementation
 *
 * @author Steve Ebersole
 */
public final class StandardDialectResolver implements DialectResolver {

	public StandardDialectResolver() {
	}

	@Override
	public Dialect resolveDialect(DialectType dialectType) {
		for ( DialectFactory database : DialectFactory.values() ) {
			if ( database.matchesResolutionInfo( dialectType ) ) {
				return database.createDialect();
			}
		}
		return null;
	}
}
