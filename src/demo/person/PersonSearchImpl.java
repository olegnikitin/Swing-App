package demo.person;

import java.util.Date;
import java.util.List;

public class PersonSearchImpl implements PersonSearch {
    
    private final List<Person> persons;

    public PersonSearchImpl(List<Person> persons) {
        this.persons = persons;
    }
    
    @Override
    public int searchPerson(String nameOfPerson) {
        for(int i = 0; i<persons.size(); i++) {
            if(persons.get(i).getName().equals(nameOfPerson)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public int searchPerson(Date dateOfBirth) {
        for(int i = 0; i<persons.size(); i++) {
            if(persons.get(i).getDateOfBirth().equals(dateOfBirth)) {
                return i;
            }
        }
        return -1;
    }
}
