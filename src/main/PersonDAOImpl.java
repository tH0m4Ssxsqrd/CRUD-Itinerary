package main;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO{
	private List<Person> people = new ArrayList<>();

    @Override
    public void addPerson(Person person) {
        people.add(person);
    }

    @Override
    public void updatePerson(Person person) {
        Person existingPerson = getPersonByName(person.getName());
        if (existingPerson != null) {
            existingPerson.setAge(person.getAge());
        }
    }

    @Override
    public void deletePerson(String name) {
        Person existingPerson = getPersonByName(name);
        if (existingPerson != null) {
            people.remove(existingPerson);
        }
    }

    @Override
    public List<Person> getAllPeople() {
        return people;
    }

    @Override
    public Person getPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

}
