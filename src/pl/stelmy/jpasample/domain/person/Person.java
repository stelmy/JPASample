package pl.stelmy.jpasample.domain.person;

import static pl.stelmy.jpasample.domain.common.TableName.Values.PERSON;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.stelmy.jpasample.domain.common.BaseEntity;
import pl.stelmy.jpasample.domain.place.Address;

/**
 * Model for person.
 * 
 * @author stelmy
 */
@Entity
@Table(name = PERSON)
public class Person extends BaseEntity {

    /**
     * The person's name.
     */
    @Embedded
    private Name name;

    /**
     * The list of previous names.
     */
    @ElementCollection
    @CollectionTable(name = ColumnNames.PREVIOUS_NAME, joinColumns = @JoinColumn(name = ColumnNames.PERSON_ID))
    private List<Name> previousNames;

    @ManyToOne
    @JoinColumn(name = ColumnNames.ADDRESS_ID)
    private Address address;

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
     * @param address
     *            the address
     */
    public Person(String firstName, String lastName, Address address) {
	super();
	this.name = new Name(firstName, lastName);
	this.previousNames = new ArrayList<Name>();
	this.address = address;
    }

    /**
     * Constructor.
     * 
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @param address
     *            the address
     * @param previousNames
     *            the previous names
     */
    public Person(String firstName, String lastName, Address address, List<Name> previousNames) {
	super();
	this.name = new Name(firstName, lastName);
	this.address = address;
	this.previousNames = previousNames;
    }

    /**
     * Following class contains column names for current entity.
     */
    private class ColumnNames {
	private static final String PREVIOUS_NAME = "PREVIOUS_NAME";
	private static final String PERSON_ID = "PERSON_ID";
	private static final String ADDRESS_ID = "ADDRESS_ID";
    }

}
