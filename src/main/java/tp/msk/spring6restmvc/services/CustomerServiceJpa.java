package tp.msk.spring6restmvc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tp.msk.spring6restmvc.mappers.CustomerMapper;
import tp.msk.spring6restmvc.model.CustomerDTO;
import tp.msk.spring6restmvc.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJpa implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    public List<CustomerDTO> customerList() {
        return null;
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID customerId) {
        return Optional.empty();
    }

    @Override
    public void updateCustomerById(UUID id, CustomerDTO customerDTO) {

    }

    @Override
    public void patchCustomerById(UUID id, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomerById(UUID id) {

    }
}
