package pl.stelmy.jpasample.dictionary;

/**
 * The person type.
 */
public enum PersonType {
    EMPLOYEE(Values.EMPLOYEE);

    /**
     * The name.
     */
    private String name;

    /**
     * Constructor.
     */
    private PersonType(String name) {
	this.name = name;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    public class Values {
	public static final String EMPLOYEE = "EMPLOYEE";
    }
}
