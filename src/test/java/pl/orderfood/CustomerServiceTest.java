package pl.orderfood;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.orderfood.business.AddressService;
import pl.orderfood.business.CustomerService;
import pl.orderfood.business.dao.CustomerDAO;
import pl.orderfood.domain.Address;
import pl.orderfood.domain.Customer;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerDAO customerDAO;

    @Mock
    private AddressService addressService;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;
    private Address address;

    @BeforeEach
    void setUp() {
        // Przygotuj dane testowe
        address = Address.builder()
                .addressId(1)
                .name("Test Address")
                .number(123)
                .build();

        customer = Customer.builder()
                .customerId(1)
                .name("John")
                .surname("Doe")
                .email("john.doe@example.com")
                .address(address)
                .build();
    }

    @Test
    void testSaveCustomer() {

        when(addressService.saveAddress(any(Address.class))).thenReturn(address);
        when(customerDAO.saveCustomer(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.saveCustomer(customer);

        verify(addressService).saveAddress(address);
        verify(customerDAO).saveCustomer(customer);

        assertEquals(savedCustomer, customer);
    }

//    @Test
//    void testSaveCustomer_WhenSaveAddressThrowsException() {
//        // Symulacja rzucenia wyjątku przez metodę saveAddress
//        when(addressService.saveAddress(any(Address.class))).thenThrow(new RuntimeException("Error saving address"));
//
//        // Wywołanie metody i sprawdzenie, czy odpowiedni wyjątek jest propagowany
//        assertThrows(RuntimeException.class, () -> customerService.saveCustomer(customer));
//
//        // Sprawdzenie, że metoda saveCustomer nie została wywołana
//        verify(customerDAO, never()).saveCustomer(any(Customer.class));
//    }

}


