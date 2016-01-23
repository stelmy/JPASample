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
    @Column(name = ColumnNames.FIRST_NAME)
    private String firstName;

    /**
     * The last name.
     */
    @Column(name = ColumnNames.LAST_NAME)
    private String lastName;

    /**
     * Default constructor.
     */
    public Name() {
	super();
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
