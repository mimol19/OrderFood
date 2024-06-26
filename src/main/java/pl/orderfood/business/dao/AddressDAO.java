package pl.orderfood.business.dao;

import pl.orderfood.domain.Address;
import pl.orderfood.domain.Meal;

import java.util.List;

public interface AddressDAO {
    Address saveAddress(Address address, String username);
    Address saveAddress(Address address);

    Address getByName(Address address);
}
