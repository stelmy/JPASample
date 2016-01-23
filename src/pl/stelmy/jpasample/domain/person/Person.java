package pl.stelmy.jpasample.domain.person;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import pl.stelmy.jpasample.domain.BaseEntity;

/**
 * Model for person.
 * 
 * @author stelmy
 */
@Entity
@Table(name = Person.TABLE_NAME)
public class Person extends BaseEntity {
    protected static final String TABLE_NAME = "PERSON";

    /**
     * The person's name.
     */
    @Embedded
    private Name name;

    /**
     * Default constructor.
     */
    public Person() {
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
    public Person(String firstName, String lastName) {
	super();
	this.name = new Name(firstName, lastName);
    }
}
