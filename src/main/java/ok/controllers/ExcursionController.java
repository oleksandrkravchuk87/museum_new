package ok.controllers;

import ok.entity.Excursion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ok.service.ExcursionService;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Controller
public class ExcursionController {
    @Autowired
    private ExcursionService excursionService;
    @RequestMapping(value = "/excursion/all", method = RequestMethod.GET)
    public String allexcursions(Model model) {
        List<Excursion> excursionList = excursionService.findAll();
        model.addAttribute("excursions", excursionList);
        return "views-excursion-all";
    }
    @RequestMapping (value = "/excursion/add", method = RequestMethod.GET)
    public String newexcursion (Model model){
        model.addAttribute("excursion", new Excursion());
        return "views-excursion-add";
    }
    @RequestMapping (value = "/excursion/create", method = RequestMethod.POST)
    public String createexcursion (@ModelAttribute Excursion excursion){
        excursionService.addOrEdit(excursion);
        return "redirect:/excursion/all";
    }
    @RequestMapping (value = "/excursion/page/{id}",method = RequestMethod.GET)
    public String excursionPage (@PathVariable String id, Model model){
        Excursion excursion = excursionService.findOne(Integer.parseInt(id));
        model.addAttribute("excursion", excursion);
        return "views-excursion-page";
    }
    @RequestMapping(value = "/excursion/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("excursion", excursionService.findOne(Integer.parseInt(id)));
        return "views-excursion-edit";
    }

    @RequestMapping(value = "/excursion/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute Excursion excursion) {
        excursionService.addOrEdit(excursion);
        return "redirect:/excursion/page/" + String.valueOf(excursion.getId());
    }

    @RequestMapping(value = "/excursion/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id) {
        excursionService.delete(Integer.parseInt(id));
        return "redirect:/excursion/all";
    }
}
