/**
 * Interface of Customer Data Access Object
 */

package com.numbr3la.dao;

import com.numbr3la.spring.entity.Customer;

import java.util.List;


public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
