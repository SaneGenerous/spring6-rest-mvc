package tp.msk.spring6restmvc.services;



import tp.msk.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDTO> customerList();
    CustomerDTO saveNewCustomer(CustomerDTO customerDTO);
    Optional<CustomerDTO> getCustomerById(UUID customerId);
    void updateCustomerById(UUID id, CustomerDTO customerDTO);
    void patchCustomerById(UUID id, CustomerDTO customerDTO);
    void deleteCustomerById(UUID id);

}
