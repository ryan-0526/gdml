package com.geominfo.gselect.context;

import java.util.EnumSet;
import java.util.Set;

/**
 * Dialects and dialect families as supported by select.
 */
public enum DialectType {

    /**
     * The H2 dialect family.
     */
    H2("h2", false),

    /**
     * The MySQL dialect family.
     */
    MYSQL("mysql", false),

    /**
     * The PostgreSQL dialect family.
     * <p>
     * While this family (and its dialects) have been observed to work to some
     * extent on Amazon RedShift as well, we strongly suggest you use the
     * official {@link #} support, instead.
     */
    POSTGRES("postgres", false),

    /**
     * The Oracle dialect family.
     */
    ORACLE("oracle", false),

    /**
     * The SqlServer dialect family.
     */
    SQLSERVER("sqlserver", false),

    /**
     * The SqlServer dialect family.
     */
    DB2("db2", false),
    ;

    private static final DialectType[] FAMILIES;

    static {
        Set<DialectType> set = EnumSet.noneOf(DialectType.class);

        for (DialectType dialect : values()) {
            set.add(dialect.family());
        }

        FAMILIES = set.toArray(new DialectType[0]);
    }

    private final String              name;
    private final boolean             commercial;
    private final DialectType family;
    private DialectType predecessor;
    private final ThirdParty          thirdParty;

    private DialectType(String name, boolean commercial) {
        this(name, commercial, null, null);
    }

    private DialectType(String name, boolean commercial, DialectType family) {
        this(name, commercial, family, null);
    }

    private DialectType(String name, boolean commercial, DialectType family, DialectType predecessor) {
        this.name = name;
        this.commercial = commercial;
        this.family = family == null ? this : family;
        this.predecessor = predecessor == null ? this : predecessor;

        if (family != null)
            family.predecessor = this;

        this.thirdParty = new ThirdParty();
    }

    /**
     * Whether this dialect is supported with the jOOQ commercial license only.
     */
    public final boolean commercial() {
        return commercial;
    }

    /**
     * The dialect family.
     * <p>
     * This returns the dialect itself, if it has no "parent family". E.g.
     * <code><pre>
     * SQLSERVER == SQLSERVER2012.family();
     * SQLSERVER == SQLSERVER2008.family();
     * SQLSERVER == SQLSERVER.family();
     * </pre></code>
     */
    public final DialectType family() {
        return family;
    }

    /**
     * Whether this dialect is a {@link #family()}.
     */
    public final boolean isFamily() {
        return this == family;
    }

    /**
     * The predecessor dialect.
     * <p>
     * If this is a dialect version (e.g. {@link #}) within a family
     * (e.g. {@link #POSTGRES}), then the predecessor will point to the
     * historically previous dialect version (e.g. {@link #}) within
     * the same family, or to the dialect itself if there was no predecessor
     * explicitly supported by jOOQ.
     */
    public final DialectType predecessor() {
        return predecessor;
    }

    /**
     * Whether this dialect precedes an other dialect from the same family.
     * <p>
     * This returns:
     * <ul>
     * <li><code>true</code> if this dialect is the same as the other dialect</li>
     * <li><code>true</code> if this dialect precedes the other dialect via any
     * number of calls to {@link #predecessor()}</li>
     * </ul>
     * The above also implies that:
     * <ul>
     * <li><code>false</code> if the two dialects do not belong to the same
     * family</li>
     * </ul>
     * <p>
     * This is useful to see if some feature is supported by <em>"at least"</em>
     * a given dialect version. Example: <code><pre>
     * // Do this block only if the chosen dialect supports PostgreSQL 9.4+ features
     * if (POSTGRES_9_4.precedes(dialect)) {
     * }
     *
     * // Do this block only if the chosen dialect supports PostgreSQL 9.3+ features
     * else if (POSTGRES_9_3.precedes(dialect)) {
     * }
     *
     * // Fall back to pre-PostgreSQL 9.3 behaviour
     * else {
     * }
     * </pre></code>
     */
    public final boolean precedes(DialectType other) {
        if (family != other.family)
            return false;

        DialectType candidate = other;
        while (candidate != null) {
            if (this == candidate)
                return true;

            if (candidate == candidate.predecessor())
                return false;

            candidate = candidate.predecessor();
        }

        return false;
    }

    /**
     * Check whether this dialect supports another one.
     * <p>
     * This is:
     * <ul>
     * <li><code>false</code> if dialects don't belong to the same family</li>
     * <li><code>true</code> if either dialect {@link #isFamily()}</li>
     * <li><code>true</code> if <code>other</code> dialect precedes this
     * dialect</li>
     * </ul>
     * <p>
     * The <code>other</code> argument dialect is typically referenced from a
     * {@link } annotation, whereas this dialect is the user dialect.
     */
    public final boolean supports(DialectType other) {
        if (family != other.family)
            return false;

        if (isFamily() || other.isFamily())
            return true;

        return other.precedes(this);
    }

    /**
     * The name of this dialect as it appears in related class names.
     */
    public final String getName() {
        return name;
    }

    /**
     * The name of this dialect as it appears in related package names.
     */
    public final String getNameLC() {
        return name == null ? null : name.toLowerCase();
    }

    /**
     * The name of this dialect as it appears in related enum values.
     */
    public final String getNameUC() {
        return name == null ? null : name.toUpperCase();
    }

    /**
     * Get a list of all {@link DialectType#family()} values.
     */
    public static final DialectType[] families() {
        return FAMILIES.clone();
    }

    /**
     * Get access to third party representations of this {@link DialectType}.
     */
    public final ThirdParty thirdParty() {
        return thirdParty;
    }

    /**
     * Third party representations of the enclosing {@link DialectType}.
     */
    public final class ThirdParty {

        public final String gsqlDialect() {
            switch (DialectType.this) {
                case H2:            return "com.geominfo.gsql.dialect.H2Dialect";
                case MYSQL:         return "com.geominfo.gsql.dialect.MySQLDialect";
                case POSTGRES:      return "com.geominfo.gsql.dialect.PostgreSQLDialect";
                case ORACLE:        return "com.geominfo.gsql.dialect.OracleDialect";
                case SQLSERVER:     return "com.geominfo.gsql.dialect.SQLServerDialect";
                default:            return null;
            }
        }
    }
}

