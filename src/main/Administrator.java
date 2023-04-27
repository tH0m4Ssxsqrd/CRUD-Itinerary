package main;

public class Administrator extends User{
	public Administrator(PersonDAO personDao) {
        super(personDao);
    }

    public void addPerson(Person person) {
        getPersonDao().addPerson(person);
    }

    public void updatePerson(Person person) {
        getPersonDao().updatePerson(person);
    }

    public void deletePerson(String name) {
        getPersonDao().deletePerson(name);
    }

}
