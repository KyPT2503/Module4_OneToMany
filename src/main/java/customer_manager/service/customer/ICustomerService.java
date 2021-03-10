package customer_manager.service.customer;

import customer_manager.model.Customer;
import customer_manager.model.Province;
import customer_manager.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> getByProvince(Province province, Pageable pageable);
    Page<Customer> getByName(Optional<String> name, Pageable pageable);
}
