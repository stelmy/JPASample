package pl.stelmy.jpasample.domain.person;

import static pl.stelmy.jpasample.domain.common.TableName.Values.PERSON;
import static pl.stelmy.jpasample.domain.person.Person.ColumnNames.PERSON_TYPE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pl.stelmy.jpasample.dictionary.Gender;
import pl.stelmy.jpasample.domain.common.BaseEntity;
import pl.stelmy.jpasample.domain.place.Address;

/**
 * Model for person.
 * 
 * @author stelmy
 */
@Entity
@Table(name = PERSON)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = PERSON_TYPE)
public abstract class Person extends BaseEntity {

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

    /**
     * The gender.
     */
    @Column(name = ColumnNames.GENDER)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * The date of birth.
     */
    @Column(name = ColumnNames.BIRTHDATE)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    /**
     * The address.
     */
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
     * @param gender
     *            the gender
     * @param birthDate
     *            the date of birth
     * @param address
     *            the address
     */
    public Person(String firstName, String lastName, Gender gender, Date birthDate, Address address) {
        super();
        this.name = new Name(firstName, lastName);
        this.gender = gender;
        this.birthDate = birthDate;
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
     * @param gender
     *            the gender
     * @param birthDate
     *            the date of birth
     * @param address
     *            the address
     * @param previousNames
     *            the previous names
     */
    public Person(String firstName, String lastName, Gender gender, Date birthDate, Address address,
            List<Name> previousNames) {
        super();
        this.name = new Name(firstName, lastName);
        this.gender = gender;
        this.address = address;
        this.previousNames = previousNames;
    }

    /**
     * Following class contains column names for current entity.
     */
    protected class ColumnNames {
        protected static final String PERSON_TYPE = "PERSON_TYPE";
        private static final String PREVIOUS_NAME = "PREVIOUS_NAME";
        private static final String PERSON_ID = "PERSON_ID";
        private static final String ADDRESS_ID = "ADDRESS_ID";
        private static final String GENDER = "GENDER";
        private static final String BIRTHDATE = "BIRTHDATE";
    }

}
