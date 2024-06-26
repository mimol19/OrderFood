package pl.orderfood.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.orderfood.business.dao.AddressDAO;
import pl.orderfood.domain.Address;

@Slf4j
@Service
@AllArgsConstructor
public class AddressService {
    private final AddressDAO addressDAO;


    @Transactional
    public Address saveAddress(Address address, String username) {
        return addressDAO.saveAddress(address, username);
    }
    @Transactional
    public Address saveAddress(Address address) {
        return addressDAO.saveAddress(address);
    }


}
