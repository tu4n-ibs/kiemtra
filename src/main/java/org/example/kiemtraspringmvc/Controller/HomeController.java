package org.example.kiemtraspringmvc.Controller;

import org.example.kiemtraspringmvc.model.thanhPho;
import org.example.kiemtraspringmvc.repository.ICityRepository;
import org.example.kiemtraspringmvc.repository.QuocGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ICityRepository cityRepository;
    @Autowired
    QuocGiaRepository quocGiaRepository;

    @GetMapping("/home")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<thanhPho> thanhPhoList = cityRepository.findAll();
        modelAndView.addObject("city", thanhPhoList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("cityForm", new thanhPho());
        modelAndView.addObject("listCountry", quocGiaRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid thanhPho thanhPho, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("cityForm", new thanhPho());
            modelAndView.addObject("listErr", bindingResult.getAllErrors());
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        cityRepository.save(thanhPho);
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("city", cityRepository.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(thanhPho thanhPho) {
        ModelAndView modelAndView = new ModelAndView("home");
        cityRepository.delete(thanhPho);
        List<thanhPho> thanhPhoList = cityRepository.findAll();
        modelAndView.addObject("city", thanhPhoList);
        modelAndView.addObject("msg", "xoa thanh cong");
        return modelAndView;
    }

    @GetMapping("/{id}/update")
    public ModelAndView updateForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("city", cityRepository.findById(id).get());

        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@Valid thanhPho thanhPho, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("update");
            modelAndView.addObject("city", new thanhPho());
            modelAndView.addObject("listErr", bindingResult.getAllErrors());
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        cityRepository.save(new thanhPho(thanhPho.getId(), thanhPho.getNameCity(), thanhPho.getCountry(), thanhPho.getArea(), thanhPho.getPopulation(), thanhPho.getGDP(), thanhPho.getDescribe()));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("search") String search){
        ModelAndView modelAndView = new ModelAndView("home");
        List<thanhPho> list = cityRepository.findAllByNameCityContains(search);
        modelAndView.addObject("city",list);
        return modelAndView;
    }
}
