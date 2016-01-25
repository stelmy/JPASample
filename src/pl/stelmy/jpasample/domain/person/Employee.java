package pl.stelmy.jpasample.domain.person;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import pl.stelmy.jpasample.dictionary.Gender;
import pl.stelmy.jpasample.dictionary.PersonType;
import pl.stelmy.jpasample.domain.place.Address;

@Entity
@DiscriminatorValue(PersonType.Values.EMPLOYEE)
public class Employee extends Person {

    public Employee() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Employee(String firstName, String lastName, Gender gender, Address address, List<Name> previousNames) {
	super(firstName, lastName, gender, address, previousNames);
	// TODO Auto-generated constructor stub
    }

    public Employee(String firstName, String lastName, Gender gender, Address address) {
	super(firstName, lastName, gender, address);
	// TODO Auto-generated constructor stub
    }

}
