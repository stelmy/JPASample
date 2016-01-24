package pl.stelmy.jpasample.domain.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class for entities.
 * 
 * @author stelmy
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public Long getId() {
	return id;
    }

}
