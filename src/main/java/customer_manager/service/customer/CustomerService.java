package customer_manager.service.customer;

import customer_manager.model.Customer;
import customer_manager.model.Province;
import customer_manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getByProvince(Province province, Pageable pageable) {
        return customerRepository.getCustomersByProvince(province, pageable);
    }

    @Override
    public Page<Customer> getByName(Optional<String> name, Pageable pageable) {
        return customerRepository.getCustomersByNameContains(name, pageable);
    }
}
