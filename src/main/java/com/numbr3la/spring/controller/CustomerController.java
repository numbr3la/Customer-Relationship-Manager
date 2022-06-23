/**
 * Customer operations controller
 * Author: numbr3la
 */
package com.numbr3la.spring.controller;


import com.numbr3la.spring.entity.Customer;
import com.numbr3la.spring.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {


    // inject our customer service
    @Autowired
    private CustomerService customerService;


    /**
     *  List of all customers in database.
     *
     * @param theModel
     * @return Name of view to display 'list-customers.jsp'
     */
    @GetMapping("/list")
    public String listCustomers(Model theModel)
    {

        // get customers from the dao
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    /**
     * Form for add new customer to database.
     *
     * @param theModel
     * @return Name of view to display 'customer-form.jsp'
     */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        // create model attrib to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    /**
     * Save updated/created customer in database
     *
     * @param theCustomer customer entity to save
     * @return Redirection to list of customers
     */
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    /**
     * Display form for update the customer data
     *
     * @param theId ID of customer who will be updated
     * @param theModel
     * @return Name of view to display 'customer-form.jsp'
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel)
    {
        // create model attrib to bind form data
        Customer theCustomer = customerService.getCustomer(theId);

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    /**
     * Delete customer from database
     *
     * @param theId ID of customer who will be deleted
     * @return Redirection to list of customers
     */
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {

        // delete customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

}
