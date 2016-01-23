package pl.stelmy.jpasample.sample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import pl.stelmy.jpasample.domain.BaseEntity;
import pl.stelmy.jpasample.domain.person.Person;

/**
 * Class for sample data adding.
 * 
 * @author stelmy
 */
public class SampleData {

    /**
     * The entity manager.
     */
    private EntityManager entityManager;

    /**
     * Constructor.
     * 
     * @param entityManager
     *            the entity manager
     */
    public SampleData(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * Creates some sample data.
     */
    public void createSampleData() {
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
     * Creates some persons.
     */
    private void createPersons() {
	List<Person> persons = new ArrayList<Person>();
	persons.add(new Person("Jan", "Kowalski"));
	persons.add(new Person("Adam", "Nowak"));
	saveData(persons);
    }
}
