package pl.stelmy.jpasample.domain.place;

import static pl.stelmy.jpasample.domain.common.TableName.Values.LOCALITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.stelmy.jpasample.domain.common.BaseEntity;

/**
 * Model for locality.
 * 
 * @author stelmy
 */
@Entity
@Table(name = LOCALITY)
public class Locality extends BaseEntity {

    /**
     * The locality name.
     */
    @Column(name = ColumnNames.NAME, length = 50)
    private String name;

    /**
     * The country.
     */
    @ManyToOne
    @JoinColumn(name = ColumnNames.LOCALITY_ID)
    private Country country;

    /**
     * Default constructor.
     */
    public Locality() {
	super();
    }

    /**
     * Constructor.
     * 
     * @param name
     *            the locality name
     * @param country
     *            the country
     */
    public Locality(String name, Country country) {
	super();
	this.name = name;
	this.country = country;
    }

    /**
     * Instantiates new locality.
     * 
     * @param name
     *            the locality name
     * @param country
     *            the country
     * @return the locality
     */
    public static Locality newLocality(String name, Country country) {
	return new Locality(name, country);
    }

    /**
     * Gets the locality name.
     * 
     * @return the locality name
     */
    public String getName() {
	return name;
    }

    /**
     * Following class contains column names for current entity.
     */
    private class ColumnNames {
	private static final String NAME = "NAME";
	private static final String LOCALITY_ID = "LOCALITY_ID";
    }
}
