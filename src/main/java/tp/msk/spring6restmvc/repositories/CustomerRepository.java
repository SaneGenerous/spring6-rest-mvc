package tp.msk.spring6restmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.msk.spring6restmvc.entities.Customer;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
