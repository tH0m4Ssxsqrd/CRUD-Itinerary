package main;

import java.util.List;

public class User {
	private PersonDAO personDao;

    public User(PersonDAO personDao) {
        this.setPersonDao(personDao);
    }

    public List<Person> getAllPeople() {
        return getPersonDao().getAllPeople();
    }

    public Person getPersonByName(String name) {
        return getPersonDao().getPersonByName(name);
    }

	public PersonDAO getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDAO personDao) {
		this.personDao = personDao;
	}
}
