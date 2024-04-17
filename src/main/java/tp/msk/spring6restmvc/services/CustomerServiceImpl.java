package tp.msk.spring6restmvc.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tp.msk.spring6restmvc.model.CustomerDTO;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final Map<UUID, CustomerDTO> customerDTOMap;

    public CustomerServiceImpl() {
        this.customerDTOMap = new HashMap<>();

        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Joe Buck")
                .version(1)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Michael Axe")
                .version(1)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO3 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Mohammed Ali")
                .version(1)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerDTOMap.put(customerDTO1.getId(), customerDTO1);
        customerDTOMap.put(customerDTO2.getId(), customerDTO2);
        customerDTOMap.put(customerDTO3.getId(), customerDTO3);
    }

    @Override
    public List<CustomerDTO> customerList() {
        return new ArrayList<>(customerDTOMap.values());
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        CustomerDTO savedCustomerDTO = CustomerDTO.builder()
                .id(customerDTO.getId())
                .name(customerDTO.getName())
                .version(customerDTO.getVersion())
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerDTOMap.put(savedCustomerDTO.getId(), savedCustomerDTO);
        return savedCustomerDTO;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID customerId) {
            log.debug("Get customer by Id - in service ID: " + customerId.toString());
            return Optional.of(customerDTOMap.get(customerId));

    }

    @Override
    public void updateCustomerById(UUID id, CustomerDTO customerDTO) {
        CustomerDTO existing = customerDTOMap.get(id);
        existing.setName(customerDTO.getName());
        existing.setVersion(customerDTO.getVersion());

        customerDTOMap.put(existing.getId(), existing);
    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customerDTO) {
        CustomerDTO existing = customerDTOMap.get(customerId);
        if (StringUtils.hasText(customerDTO.getName())) {
            existing.setName(customerDTO.getName());
        }


    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerDTOMap.remove(customerId);
    }
}
