package pl.stelmy.jpasample.domain.person;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Class contains first name and last name of person.
 * 
 * @author stelmy
 */
@Embeddable
public class Name {

    /**
     * The first name.
     */
    @Column(name = ColumnNames.FIRST_NAME, length = 50)
    private String firstName;

    /**
     * The last name.
     */
    @Column(name = ColumnNames.LAST_NAME, length = 50)
    private String lastName;

    /**
     * Default constructor.
     */
    public Name() {
	super();
    }

    /**
     * Instantiates new name.
     * 
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the name
     */
    public static Name name(String firstName, String lastName) {
	return new Name(firstName, lastName);
    }

    /**
     * Constructor.
     * 
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     */
    public Name(String firstName, String lastName) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
    }

    /**
     * Following class contains column names for current entity.
     */
    private class ColumnNames {
	private static final String FIRST_NAME = "FIRST_NAME";
	private static final String LAST_NAME = "LAST_NAME";
    }

}
