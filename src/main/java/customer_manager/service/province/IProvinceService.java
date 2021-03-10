package customer_manager.service.province;

import customer_manager.model.Province;
import customer_manager.service.IGeneralService;

import java.util.List;

public interface IProvinceService extends IGeneralService<Province> {
    Iterable<Province> findAllDefault();
}
