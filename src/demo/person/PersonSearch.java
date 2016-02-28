package demo.person;

import java.util.Date;

public interface PersonSearch {
    int searchPerson(String nameOfPerson);
    int searchPerson(Date dateOfBirth);
}
