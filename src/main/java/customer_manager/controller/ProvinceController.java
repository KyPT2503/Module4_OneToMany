package customer_manager.controller;

import customer_manager.model.Province;
import customer_manager.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("province-create", "province", new Province());
    }

    @PostMapping("/createe")
    public ModelAndView create(@ModelAttribute("province") Province province) {
        provinceService.add(province);
        return new ModelAndView("redirect:/province/create");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        provinceService.remove(id);
        return new ModelAndView("redirect:/customer/all");
    }
}
