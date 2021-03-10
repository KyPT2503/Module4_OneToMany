package customer_manager.service.province;

import customer_manager.model.Province;
import customer_manager.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Province findById(int id) {
        return provinceRepository.findOne(id);
    }

    @Override
    public Province add(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public void remove(int id) {
        provinceRepository.delete(id);
    }

    @Override
    public Province update(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public Iterable<Province> findAllDefault() {
        return provinceRepository.findAll();
    }
}
