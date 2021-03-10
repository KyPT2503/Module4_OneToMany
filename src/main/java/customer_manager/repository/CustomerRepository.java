package customer_manager.repository;

import customer_manager.model.Customer;
import customer_manager.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    Page<Customer> getCustomersByProvince(Province province, Pageable pageable);
    /*Page<Customer> findAllByProvince(Province province);*/
}
