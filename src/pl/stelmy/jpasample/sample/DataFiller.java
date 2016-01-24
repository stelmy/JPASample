package pl.stelmy.jpasample.sample;

import static pl.stelmy.jpasample.domain.person.Name.name;
import static pl.stelmy.jpasample.domain.place.Address.newAddress;
import static pl.stelmy.jpasample.domain.place.Country.newCountry;
import static pl.stelmy.jpasample.domain.place.Locality.newLocality;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import pl.stelmy.jpasample.domain.common.BaseEntity;
import pl.stelmy.jpasample.domain.person.Name;
import pl.stelmy.jpasample.domain.person.Person;
import pl.stelmy.jpasample.domain.place.Address;
import pl.stelmy.jpasample.domain.place.Country;
import pl.stelmy.jpasample.domain.place.Locality;

/**
 * Class for sample data adding.
 * 
 * @author stelmy
 */
public class DataFiller {
    private List<Country> countries;
    private List<Locality> localities;
    private List<Address> addresses;

    /**
     * The entity manager.
     */
    private EntityManager entityManager;

    /**
     * The random generator.
     */
    private Random randomGenerator;

    /**
     * Constructor.
     * 
     * @param entityManager
     *            the entity manager
     */
    public DataFiller(EntityManager entityManager) {
	this.entityManager = entityManager;
	this.randomGenerator = new Random();
	createSampleData();
    }

    /**
     * Creates some sample data.
     */
    private void createSampleData() {
	countries = createCountries();
	localities = createLocalities();
	addresses = createAddresses();
	createPersons();
    }

    /**
     * Saves created data into the database.
     * 
     * @param entities
     *            the entities to save
     */
    private void saveData(List<? extends BaseEntity> entities) {
	entities.forEach(entity -> entityManager.persist(entity));
    }

    /**
     * Gets random entity from list.
     * 
     * @param entities
     *            the list of entities
     * @return the random entity
     */
    private BaseEntity findRandomEntity(List<? extends BaseEntity> entities) {
	int randomIndex = randomGenerator.nextInt(entities.size());
	return entities.get(randomIndex);
    }

    /**
     * Creates some persons.
     */
    private void createPersons() {
	List<Person> persons = new ArrayList<Person>();
	persons.add(new Person("Jan", "Kowalski", findRandomAddress()));
	persons.add(new Person("Adam", "Nowak", findRandomAddress()));
	persons.add(new Person("Gra¿yna", "Nowak", findRandomAddress(), previousNames(name("Gra¿yna", "Matysik"))));
	saveData(persons);
    }

    /**
     * Creates some countries.
     * @return the countries
     */
    private List<Country> createCountries() {
	List<Country> countries = new ArrayList<Country>();
	countries.add(newCountry("Poland"));
	countries.add(newCountry("Russia"));
	countries.add(newCountry("France"));
	countries.add(newCountry("Germany"));
	countries.add(newCountry("Italy"));
	countries.add(newCountry("Japan"));
	saveData(countries);
	return countries;
    }
    
    private List<Locality> createLocalities() {
	List<Locality> localities = new ArrayList<Locality>();
	localities.add(newLocality("Warsaw", findCountryByName("Poland")));
	localities.add(newLocality("Lublin", findCountryByName("Poland")));
	localities.add(newLocality("Berlin", findCountryByName("Germany")));
	localities.add(newLocality("Moscow", findCountryByName("Russia")));
	saveData(localities);
	return localities;
    }

    private List<Address> createAddresses() {
	List<Address> addresses = new ArrayList<Address>();
	addresses.add(newAddress(findLocalityByName("Warsaw"), "00-050", "ul. Cudowna", "60b"));
	saveData(addresses);
	return addresses;
    }

    private List<Name> previousNames(Name... names) {
	List<Name> nameList = new ArrayList<Name>();
	for (Name name : names) {
	    nameList.add(name);
	}
	return nameList;
    }
    
    private Country findCountryByName(String name) {
	return countries.stream().filter(country -> country.getName().equals(name)).findFirst().get();
    }
    
    private Locality findLocalityByName(String name) {
	return localities.stream().filter(locality -> locality.getName().equals(name)).findFirst().get();
    }
    
    private Address findRandomAddress() {
	return (Address) findRandomEntity(addresses);
    }
}
