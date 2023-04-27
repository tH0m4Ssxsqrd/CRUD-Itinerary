package main;

import java.util.List;

public interface PersonDAO {
	void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(String name);
    List<Person> getAllPeople();
    Person getPersonByName(String name);

}
