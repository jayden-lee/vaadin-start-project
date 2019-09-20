package com.jayden.myapp.domain;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerService {

    private static CustomerService instance;
    private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

    private final Map<Long, Customer> contacts = new HashMap<>();
    private long nextId = 0;

    private CustomerService() {

    }

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
            instance.ensureTestData();
        }
        return instance;
    }


    public List<Customer> findAll() {
        return findAll(null);
    }

    public List<Customer> findAll(String filterText) {
        List<Customer> arrayList = new ArrayList<>();
        for (Customer contact : contacts.values()) {
            try {
                boolean passesFilter = (StringUtils.isEmpty(filterText))
                    || contact.toString().toLowerCase().contains(filterText.toLowerCase());
                if (passesFilter) {
                    arrayList.add(contact.clone());
                }
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Collections.sort(arrayList, (o1, o2) -> (int) (o2.getId() - o1.getId()));

        return arrayList;
    }

    public List<Customer> findAll(String stringFilter, int start, int maxResult) {
        ArrayList<Customer> arrayList = new ArrayList<>();
        for (Customer contact : contacts.values()) {
            try {
                boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
                    || contact.toString().toLowerCase().contains(stringFilter.toLowerCase());
                if (passesFilter) {
                    arrayList.add(contact.clone());
                }
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Collections.sort(arrayList, (o1, o2) -> (int) (o2.getId() - o1.getId()));

        int end = start + maxResult;
        if (end > arrayList.size()) {
            end = arrayList.size();
        }

        return arrayList.subList(start, end);
    }

    public long count() {
        return contacts.size();
    }

    public void delete(Customer value) {
        contacts.remove(value.getId());
    }

    public void save(Customer entry) {
        if (entry == null) {
            LOGGER.log(Level.SEVERE,
                "Customer is null. Are you sure you have connected your form to the application as described in tutorial chapter 7?");
            return;
        }

        if (entry.getId() == null) {
            entry.setId(nextId++);
        }

        try {
            entry = (Customer) entry.clone();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        contacts.put(entry.getId(), entry);
    }

    public void ensureTestData() {
        if (findAll().isEmpty()) {
            final String[] names = new String[]{"Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                "Jaydan Jackson", "Bernard Nilsen"};
            Random r = new Random(0);
            for (String name : names) {
                String[] split = name.split(" ");
                Customer c = new Customer();
                c.setFirstName(split[0]);
                c.setLastName(split[1]);
                c.setStatus(CustomerStatus.values()[r.nextInt(CustomerStatus.values().length)]);
                c.setBirthDate(LocalDate.now().minusDays(r.nextInt(365 * 100)));
                save(c);
            }
        }
    }

}
