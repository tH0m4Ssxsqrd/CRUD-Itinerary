package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        PersonDAO personDao = new PersonDAOImpl();
        User user = new User(personDao);
        Administrator admin = new Administrator(personDao);
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("Are you a user or an administrator? (U/A)");
			    String userType = scanner.nextLine();

			    if (userType.equalsIgnoreCase("U")) {
			        while (true) {
			            System.out.println("What would you like to do?");
			            System.out.println("1. View all people");
			            System.out.println("2. Search for a person");
			            System.out.println("3. Exit");
			            int choice = Integer.parseInt(scanner.nextLine());

			            if (choice == 1) {
			                for (Person person : user.getAllPeople()) {
			                    System.out.println(person.getName() + ", " + person.getAge());
			                }
			            } else if (choice == 2) {
			                System.out.println("Enter the name of the person:");
			                String name = scanner.nextLine();
			                Person person = user.getPersonByName(name);
			                if (person != null) {
			                    System.out.println(person.getName() + ", " + person.getAge());
			                } else {
			                    System.out.println("Person not found.");
			                }
			            } else if (choice == 3) {
			                break;
			            } else {
			                System.out.println("Invalid choice. Please try again.");
			            }
			        }
			    } else if (userType.equalsIgnoreCase("A")) {
			        while (true) {
			            System.out.println("What would you like to do?");
			            System.out.println("1. Add a person");
			            System.out.println("2. Update a person");
			            System.out.println("3. Delete a person");
			            System.out.println("4. View all people");
			            System.out.println("5. Search for a person");
			            System.out.println("6. Exit");
			            int choice = Integer.parseInt(scanner.nextLine());

			            if (choice == 1) {
			                System.out.println("Enter the name of the person:");
			                String name = scanner.nextLine();
			                System.out.println("Enter the age of the person:");
			                int age = Integer.parseInt(scanner.nextLine());
			                Person person = new Person(name, age);
			                admin.addPerson(person);
			                System.out.println("Person added.");
			            } else if (choice == 2) {
			                System.out.println("Enter the name of the person:");
			                String name = scanner.nextLine();
			                System.out.println("Enter the new age of the person:");
			                int age = Integer.parseInt(scanner.nextLine());
			                Person person = new Person(name, age);
			                admin.updatePerson(person);
			                System.out.println("Person updated.");
			            } else if (choice == 3) {
			                System.out.println("Enter the name of the person:");
			                String name = scanner.nextLine();
			                admin.deletePerson(name);
			                System.out.println("Person deleted.");
			            } else if (choice == 4) {
			                for (Person person : user.getAllPeople()) {
			                    System.out.println(person.getName() + ", " + person.getAge());
			                }
			            } else if (choice == 5) {
			                System.out.println("Enter the name of the person:");
			                String name = scanner.nextLine();
			                Person person = user.getPersonByName(name);
			                if (person != null) {
			                    System.out.println(person.getName() + ", " + person.getAge());
			                } else {
			                    System.out.println("Person not found.");
			                }
			            } else if (choice == 6) {
			                break;
			            } else {
			                System.out.println("Invalid choice. Please try again.");
			            }
			        }
			    }
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
