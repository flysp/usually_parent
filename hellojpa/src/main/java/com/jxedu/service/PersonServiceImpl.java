package com.jxedu.service;

import com.jxedu.dao.PersonDao;
import com.jxedu.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl  implements  PersonService{


       public PersonServiceImpl(){

           System.out.println();
       }

     @Autowired
      private PersonDao personDao;


    @Override
    public Person findPersonById(Long personId) {
        return personDao.findOne(personId);
    }

    @Override
    public void updatePerson(Person person) {

          //  personDao.updatePersonAddress(person);
    }

    @Override
    public void deletePerson(Long personId) {

           personDao.delete(personId);
    }

    @Override
    public void savePerson(Person person) {

          personDao.save(person);
    }

    @Override
    public List<Person> findPerson(){

        return personDao.findAll();
    }
}
