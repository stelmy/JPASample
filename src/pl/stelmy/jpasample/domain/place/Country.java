package pl.stelmy.jpasample.domain.place;

import static pl.stelmy.jpasample.domain.common.TableName.Values.COUNTRY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pl.stelmy.jpasample.domain.common.BaseEntity;

/**
 * Model for country.
 * 
 * @author stelmy
 */
@Entity
@Table(name = COUNTRY)
public class Country extends BaseEntity {

    /**
     * The country name.
     */
    @Column(name = ColumnNames.NAME, length = 50)
    private String name;

    /**
     * Default constructor.
     */
    public Country() {
	super();
    }

    /**
     * Constructor.
     * 
     * @param name
     *            the country name
     */
    public Country(String name) {
	super();
	this.name = name;
    }

    /**
     * Instantiates new country.
     * 
     * @param name
     *            the country name
     * @return the country
     */
    public static Country newCountry(String name) {
	return new Country(name);
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Following class contains column names for current entity.
     */
    private class ColumnNames {
	private static final String NAME = "NAME";
    }
}
