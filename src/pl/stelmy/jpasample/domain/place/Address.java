package pl.stelmy.jpasample.domain.place;

import static pl.stelmy.jpasample.domain.common.TableName.Values.ADDRESS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.stelmy.jpasample.domain.common.BaseEntity;

/**
 * Class for address data.
 * 
 * @author stelmy
 */
@Entity
@Table(name = ADDRESS)
public class Address extends BaseEntity {

    /**
     * The locality.
     */
    @ManyToOne
    @JoinColumn(name = ColumnNames.LOCALITY_ID)
    private Locality locality;

    /**
     * The postal code.
     */
    @Column(name = ColumnNames.POSTCODE)
    private String postcode;

    /**
     * The street name.
     */
    @Column(name = ColumnNames.STREET)
    private String street;

    /**
     * The street number.
     */
    @Column(name = ColumnNames.STREET_NUMBER)
    private String streetNumber;

    /**
     * Default constructor.
     */
    public Address() {
	super();
    }

    /**
     * Constructor.
     * 
     * @param locality
     *            the locality
     * @param postcode
     *            the postal code
     * @param street
     *            the street name
     * @param streetNumber
     *            the street number
     */
    public Address(Locality locality, String postcode, String street, String streetNumber) {
	super();
	this.locality = locality;
	this.postcode = postcode;
	this.street = street;
	this.streetNumber = streetNumber;
    }

    /**
     * Instantiates new address.
     * 
     * @param locality
     *            the locality
     * @param postcode
     *            the postal code
     * @param street
     *            the street name
     * @param streetNumber
     *            the street number
     */
    public static Address newAddress(Locality locality, String postcode, String street, String streetNumber) {
	return new Address(locality, postcode, street, streetNumber);
    }

    /**
     * Following class contains column names for current entity.
     */
    private class ColumnNames {
	private static final String POSTCODE = "POSTCODE";
	private static final String STREET = "STREET";
	private static final String STREET_NUMBER = "STREET_NUMBER";
	private static final String LOCALITY_ID = "LOCALITY_ID";
    }

}
