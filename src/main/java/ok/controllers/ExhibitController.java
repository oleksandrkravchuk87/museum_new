package ok.controllers;

import ok.dto.ExhibitDTO;
import ok.entity.Exhibit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ok.service.ExhibitService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Controller
public class ExhibitController {
    @Autowired
    private ExhibitService exhibitService;


    @RequestMapping(value = "/exhibit/all", method = RequestMethod.GET)
    public String allexhibits(Model model) {
        List<ExhibitDTO> exhibitList = exhibitService.findAll();
        model.addAttribute("exhibits", exhibitList);
        return "views-exhibit-all";
    }


    @RequestMapping(value = "/exhibit/add", method = RequestMethod.GET)
    public String newexhibit(Model model) {
        model.addAttribute("exhibit", new Exhibit());
        return "views-exhibit-add";
    }

    @RequestMapping(value = "/exhibit/new", method = RequestMethod.POST)
    public String createexhibit(@RequestParam("description") String description, @RequestParam("timePeriod") String timePeriod, @RequestParam("material") String material, @RequestParam("origin") String origin, @RequestParam("miniature") MultipartFile multipartFile) {
        exhibitService.addOrEdit(description, timePeriod, material, origin, multipartFile);
        return "redirect:/exhibit/all";
    }

    @RequestMapping(value = "/exhibit/page/{id}", method = RequestMethod.GET)
    public String exhibitPage(@PathVariable String id, Model model) {
        Exhibit exhibit = exhibitService.findOne(Integer.parseInt(id));
        model.addAttribute("exhibit", exhibit);
        return "views-exhibit-page";
    }

    @RequestMapping(value = "/exhibit/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("exhibit", exhibitService.findOne(Integer.parseInt(id)));
        return "views-exhibit-edit";
    }

    @RequestMapping(value = "/exhibit/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id")int id, @RequestParam("description") String description, @RequestParam("timePeriod") String timePeriod, @RequestParam("material") String material, @RequestParam("origin") String origin, @RequestParam("miniature") MultipartFile multipartFile) {
        exhibitService.edit(id, description, timePeriod, material, origin, multipartFile);
        return "redirect:/exhibit/all";
    }

    @RequestMapping(value = "/exhibit/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id) {
        exhibitService.delete(Integer.parseInt(id));
        return "redirect:/exhibit/all";
    }
}


