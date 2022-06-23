/**
 * Implementation of interface Customer Data Access Object
 */

package com.numbr3la.dao;

import com.numbr3la.spring.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Get list of all customers in database
     * @return List of customers
     */
    @Override
    public List<Customer> getCustomers() {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query, sort by lastname
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the result
        return customers;

    }

    /**
     * Save passed customer in databse.
     *
     * @param theCustomer customer object which will be saved in db
     */
    @Override
    public void saveCustomer(Customer theCustomer) {

        // get curr hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);

    }

    /**
     * Get customer by ID
     *
     * @param theId the ID of customer who will be returned
     * @return Customer with passed ID
     */
    @Override
    public Customer getCustomer(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, theId);
        return customer;

    }

    /**
     * Delete customer by ID
     *
     * @param theId the ID of customer who will be deleted
     */
    @Override
    public void deleteCustomer(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();

    }


}
