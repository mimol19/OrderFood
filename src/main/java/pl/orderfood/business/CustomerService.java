package pl.orderfood.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.orderfood.business.dao.CustomerDAO;
import pl.orderfood.domain.Address;
import pl.orderfood.domain.Customer;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerDAO customerDAO;
    private final AddressService addressService;
    public Customer saveCustomer(Customer customer) {
        Address address = customer.getAddress();
        System.out.println();
        Address savedAddress = addressService.saveAddress(address);
        customer.setAddress(savedAddress);
        return customerDAO.saveCustomer(customer);
    }
}
