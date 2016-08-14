package ok.controllers;

import ok.dto.ExhibitImageDTO;
import ok.entity.Exhibit;
import ok.entity.ExhibitImage;
import ok.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ok.service.ExhibitImageService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Controller
public class ExhibitImageController {
@Autowired
    private ExhibitImageService exhibitImageService;
    @Autowired
    private ExhibitService exhibitService;
    @RequestMapping(value = "/exhibitImage/all/{id}", method = RequestMethod.GET)
    public String allexhibitImages(@PathVariable String id, Model model) {
        List<ExhibitImageDTO> exhibitImageList = exhibitImageService.findAllImages(Integer.parseInt(id));
        Exhibit exhibit =exhibitService.findOne(Integer.parseInt(id));
        model.addAttribute("exhibitImages", exhibitImageList);
        model.addAttribute("exhibit", exhibit.getId());

        return "views-exhibitImage-all";
    }


    @RequestMapping (value = "/exhibitImage/add/{id}", method = RequestMethod.GET)
    public String newexhibitImage (@PathVariable String id, Model model){
        model.addAttribute("exhibitImage", new ExhibitImage());
        model.addAttribute("id", id);
        return "views-exhibitImage-add";
    }
    @RequestMapping (value = "/exhibitImage/new", method = RequestMethod.POST)
    public String createexhibitImage (@RequestParam("id")int id, @RequestParam("image") MultipartFile multipartFile){
        exhibitImageService.addOrEdit(id, multipartFile);
        return "redirect:/exhibitImage/all/"+String.valueOf(id);
    }
    @RequestMapping (value = "/exhibitImage/page/{id}",method = RequestMethod.GET)
    public String exhibitImagePage (@PathVariable String id, Model model){
        ExhibitImage exhibitImage = exhibitImageService.findOne(Integer.parseInt(id));
        model.addAttribute("exhibitImage", exhibitImage);
        return "views-exhibitImage-page";
    }
    @RequestMapping(value = "/exhibitImage/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("exhibitImage", exhibitImageService.findOne(Integer.parseInt(id)));
        return "views-exhibitImage-edit";
    }

    @RequestMapping(value = "/exhibitImage/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute ExhibitImage exhibitImage) {
        exhibitImageService.addOrEdit(exhibitImage);
        return "redirect:/exhibitImage/page/" + String.valueOf(exhibitImage.getId());
    }

    @RequestMapping(value = "/exhibitImage/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id, @RequestParam("exId") int exId) {
        exhibitImageService.delete(Integer.parseInt(id));

        return "redirect:/exhibitImage/all/"+String.valueOf(exId);
    }

//    @RequestMapping(value = "/exhibit/addImage/{id}", method = RequestMethod.GET)
//    public String addImage(@PathVariable String id, Model model) {
//        model.addAttribute("exhibit", exhibitService.findOne(Integer.parseInt(id)));
//        return "views-exhibit-addImage";
//    }
//
//    @RequestMapping(value = "/exhibit/addImage", method = RequestMethod.POST)
//    public String addImage(@RequestParam("id") int id, @RequestParam("image") MultipartFile multipartFile) {
//        exhibitService.addImage(id, multipartFile);
//        return "redirect:/exhibit/all";
//    }



}
