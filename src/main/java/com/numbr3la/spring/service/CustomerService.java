/**
 * Interface of Customer Services in db
 * Author: numbr3la
 */

package com.numbr3la.spring.service;

import com.numbr3la.spring.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
