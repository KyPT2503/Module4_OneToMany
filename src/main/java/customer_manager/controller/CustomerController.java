package customer_manager.controller;

import customer_manager.model.Customer;
import customer_manager.model.Province;
import customer_manager.service.customer.ICustomerService;
import customer_manager.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> getAllProvince() {
        return provinceService.findAllDefault();
    }

    @GetMapping("/all")
    public ModelAndView showCustomers(@PageableDefault(size = 3) Pageable pageable) {
        return new ModelAndView("index", "customers", customerService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("create", "customer", new Customer());
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("customer") Customer customer) {
        customerService.add(customer);
        return new ModelAndView("redirect:/customer/all");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdatePage(@PathVariable("id") int id) {
        return new ModelAndView("create", "customer", customerService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("customer") Customer customer) {
        customerService.update(customer);
        return new ModelAndView("redirect:/customer/all");
    }
}
