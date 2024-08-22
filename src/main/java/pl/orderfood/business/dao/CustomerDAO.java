package pl.orderfood.business.dao;

import pl.orderfood.domain.Customer;

public interface CustomerDAO {
    Customer saveCustomer(Customer customer);
}
