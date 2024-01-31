package com.perscholas.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import com.perscholas.model.Person;


/**
 * Unit test for simple App.
 */
public class AppTest
{


    @Test
    public void testPersonLookUp() {

        //SessionFactory factory = new Configuration().configure().buildSessionFactory();
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        //========================
        // GOAL:   Test that a Person Object exists in the database
        // with name="Bill Board"
        //=========================

        String sql = "SELECT name FROM Person WHERE name ='Bill Board'";
        Query query = session.createNativeQuery(sql);
        List<Object[]> person = query.getResultList();
        if(person.isEmpty()){
            assertEquals("no", "rows found");
        }
        Object tmp = person.get(0);
        Person testPerson = new Person();
        testPerson.setName("Bill Board");
        assertEquals(tmp.toString(), testPerson.getName());

        session.close();
        System.out.println("Session Closed");
    }

    @Test
    public void testAddressLookUp() {
        //========================
        // GOAL:   Test that a Address Object exists in the database
        // with city="nyc"
        //=========================

    }
}
