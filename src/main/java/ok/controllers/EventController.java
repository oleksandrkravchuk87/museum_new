package ok.controllers;

import ok.dto.EventDTO;
import ok.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ok.service.EventService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Controller
public class EventController {
    @Autowired
    private EventService eventService;


    @RequestMapping(value = "/event/all", method = RequestMethod.GET)
    public String allevents(Model model) {
        List<EventDTO> eventList = eventService.findAll();
        model.addAttribute("events", eventList);
        return "views-event-all";
    }


    @RequestMapping(value = "/event/add", method = RequestMethod.GET)
    public String newevent(Model model) {
        model.addAttribute("event", new Event());
        return "views-event-add";
    }


    @RequestMapping(value = "/event/new", method = RequestMethod.POST)
    public String createevent(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("passingDate") String passingDate, @RequestParam("image") MultipartFile multipartFile) {
        eventService.addOrEdit(name, description, passingDate, multipartFile);
        return "redirect:/event/all";
    }

    @RequestMapping(value = "/event/page/{id}", method = RequestMethod.GET)
    public String eventPage(@PathVariable String id, Model model) {
        Event event = eventService.findOne(Integer.parseInt(id));
        model.addAttribute("event", event);
        return "views-event-page";
    }

    @RequestMapping(value = "/event/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("event", eventService.findOne(Integer.parseInt(id)));
        return "views-event-edit";
    }

    @RequestMapping(value = "/event/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("passingDate") String passingDate, @RequestParam("image") MultipartFile multipartFile) {
        eventService.edit(id, name, description, passingDate,  multipartFile);
        return "redirect:/event/all";
    }

    @RequestMapping(value = "/event/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id) {
        eventService.delete(Integer.parseInt(id));
        return "redirect:/event/all";
    }
}
