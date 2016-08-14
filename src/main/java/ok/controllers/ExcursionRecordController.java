package ok.controllers;

import ok.entity.Excursion;
import ok.entity.ExcursionRecord;
import ok.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ok.service.ExcursionRecordService;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Controller
public class ExcursionRecordController {
    @Autowired
private ExcursionRecordService excursionRecordService;
    @Autowired
    private ExcursionService excursionService;
    @RequestMapping(value = "/excursionRecord/all", method = RequestMethod.GET)
    public String allexcursionRecords(Model model) {
        List<ExcursionRecord> excursionRecordList = excursionRecordService.findAll();
        model.addAttribute("excursionRecords", excursionRecordList);
        return "views-excursionRecord-all";
    }
    @RequestMapping (value = "/excursionRecord/add/{id}", method = RequestMethod.GET)
    public String newexcursionRecord (@PathVariable String id, Model model){
        //model.addAttribute("excursionRecord", new ExcursionRecord());
        Excursion excursion = excursionService.findOne(Integer.parseInt(id));
        model.addAttribute("excursion", excursion);
        return "views-excursionRecord-add";
    }
    @RequestMapping (value = "/excursionRecord/new", method = RequestMethod.POST)
    public String createexcursionRecord (@RequestParam("excursionId")int excursionId, @RequestParam("userId")String userId, @RequestParam("excursionDay")String excursionDay, @RequestParam("excursionStart")String excursionStart){

        excursionRecordService.addOrEdit(excursionId, userId, excursionDay, excursionStart);

        return "redirect:/user/cabinet/"+String.valueOf(userId);
    }
    @RequestMapping (value = "/excursionRecord/page/{id}",method = RequestMethod.GET)
    public String excursionRecordPage (@PathVariable String id, Model model){
        ExcursionRecord excursionRecord = excursionRecordService.findOne(Integer.parseInt(id));
        model.addAttribute("excursionRecord", excursionRecord);
        return "views-excursionRecord-page";
    }
    @RequestMapping(value = "/excursionRecord/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("excursionRecord", excursionRecordService.findOne(Integer.parseInt(id)));
        return "views-excursionRecord-edit";
    }

    @RequestMapping(value = "/excursionRecord/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute ExcursionRecord excursionRecord) {
        excursionRecordService.addOrEdit(excursionRecord);
        return "redirect:/excursionRecord/page/" + String.valueOf(excursionRecord.getId());
    }

    @RequestMapping(value = "/excursionRecord/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id, @RequestParam("userId")String userId) {
        excursionRecordService.delete(Integer.parseInt(id));
        return "redirect:/user/cabinet/"+String.valueOf(userId);
    }
}
