package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     *
     * @param persons  the list of persons
     * @param manager  the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary   the salary increase to be given
     * @throws ClassCastException       when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException   when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary) {
        Manager m = null;
        Employee em = null;
        for (Person person : persons) {
            if (person.getName().equals(manager)) {
                if (!(person instanceof Manager)) {
                    throw new ClassCastException(manager + " is not a manager");
                }
                m = (Manager) person;
            }
            if (person.getName().equals(employee)) {
                if (!(person instanceof Employee)) {
                    throw new ClassCastException(employee + " is not an employee");
                }
                em = (Employee) person;
            }
        }

        if (m == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }

        if (em == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }
        m.giveRaise(em, salary);

    }

    /**
     * TODO this implementation
     *
     * @param persons   the list of persons
     * @param developer the developer to be assigned
     * @param manager   the manager assigned to the dev
     * @throws ClassCastException     when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException  when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Developer deve = null;
        Manager manag = null;

        for (Person person : persons) {
            if (person.getName().equals(developer)) {
                if (!(person instanceof Developer)) {
                    throw new ClassCastException(developer + " is not a developer");
                }
                deve = (Developer) person;
            }
            if (person.getName().equals(manager)) {
                if (!(person instanceof Manager)) {
                    throw new ClassCastException(manager + " is not a manager");
                }
                manag = (Manager) person;
            }
        }

        if (manag == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }

        if (deve == null) {
            throw new NoSuchElementException(developer + " does not exist");
        }

        deve.setProjectManager(manag);
    }

    /**
     * TODO this implementation
     *
     * @param persons  the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws IllegalArgumentException when given customer or employee is not what they are
     * @throws NoSuchElementException   when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer c = null;
        Employee em = null;

        for (Person person : persons) {
            if (person.getName().equals(customer)) {
                if (!(person instanceof Customer)) {
                    throw new ClassCastException(customer + " is not a customer");
                }
                c = (Customer) person;
            }
            if (person.getName().equals(employee)) {
                if (!(person instanceof Employee)) {
                    throw new ClassCastException(employee + " is not an employee");
                }
                em = (Employee) person;
            }
        }

        if (c == null) {
            throw new NoSuchElementException(customer + " does not exist");
        }

        if (em == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }

        return c.speak(em);
    }

}

