package pl.stelmy.jpasample.domain.common;

/**
 * The names of all entity tables.
 * 
 * @author stelmy
 */
public enum TableName {
    PERSON(Values.PERSON),
    ADDRESS(Values.ADDRESS),
    COUNTRY(Values.COUNTRY),
    LOCALITY(Values.LOCALITY);

    /**
     * The table name.
     */
    private String name;

    /**
     * Constructor.
     * 
     * @param name
     *            the table name
     */
    private TableName(String name) {
	this.name = name;
    }

    /**
     * Gets the table name.
     * 
     * @return the table name
     */
    public String getName() {
	return name;
    }

    /**
     * Following class contains constants with table names.
     */
    public class Values {
	public static final String PERSON = "PERSON";
	public static final String ADDRESS = "ADDRESS";
	public static final String COUNTRY = "COUNTRY";
	public static final String LOCALITY = "LOCALITY";
    }
}
