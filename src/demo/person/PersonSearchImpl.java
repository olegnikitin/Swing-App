package demo.person;

import java.util.*;

public class PersonSearchImpl implements PersonSearch {

    private final List<Person> persons;
    private final List<String> dates;

    public PersonSearchImpl(List<Person> persons, List<String> dates) {
        this.persons = persons;
        this.dates = dates;
    }

    public int searchPerson(String nameOfPerson) {
        for(int i = 0; i<persons.size(); i++) {
            if(persons.get(i).getName().startsWith(nameOfPerson)) {
                return i;
            }
        }
        return -1;
    }
}
