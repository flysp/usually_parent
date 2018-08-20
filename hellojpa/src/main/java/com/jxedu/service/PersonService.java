package com.jxedu.service;

import com.jxedu.entity.Person;
import java.util.List;

public interface PersonService {

        Person findPersonById(Long personId);

        void  updatePerson(Person person);

        void deletePerson(Long personId);

        void savePerson(Person person);

        List<Person> findPerson();
}
