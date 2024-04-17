package tp.msk.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import tp.msk.spring6restmvc.entities.Customer;
import tp.msk.spring6restmvc.model.CustomerDTO;

@Mapper
public interface CustomerMapper {
    Customer customerDTOtoCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDTO(Customer customer);
}
