package customer_manager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneralService<E> {
    Page<E> findAll(Pageable pageable);

    E findById(int id);

    E add(E e);

    void remove(int id);

    E update(E e);
}
