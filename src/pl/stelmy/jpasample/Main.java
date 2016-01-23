package pl.stelmy.jpasample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.stelmy.jpasample.sample.SampleData;

/**
 * Main class.
 * 
 * @author stelmy
 */
public class Main {

    /**
     * Main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
	// Creates the entity manager factory.
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPASample");

	// Creates the entity manager.
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	// Begins the transaction.
	entityManager.getTransaction().begin();

	// Adds sample data.
	(new SampleData(entityManager)).createSampleData();

	// Commits the transaction.
	entityManager.getTransaction().commit();

	// Closes the entity manager.
	entityManager.close();

	// Closes the entity manager factory.
	entityManagerFactory.close();
    }

}
