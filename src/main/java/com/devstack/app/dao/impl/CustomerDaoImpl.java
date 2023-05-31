package com.devstack.app.dao.impl;

import com.devstack.app.dao.CustomerDao;
import com.devstack.app.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Customer> findAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customer = session.createQuery("FROM Customer", Customer.class).getResultList();
        return customer;
    }


    public void saveCustomer(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }


    public Customer findCustomer(long id) {
        return sessionFactory.getCurrentSession().find(Customer.class,id);
    }


    public void deleteCustomer(long id) {
        sessionFactory.getCurrentSession()
                .delete(sessionFactory.getCurrentSession().find(Customer.class,id));
    }
}
