package ok.controllers;

import ok.dto.EventDTO;
import ok.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Controller
public class BaseController {
    @Autowired
    private EventService eventService;

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String home (Model model){
        List<EventDTO> eventList = eventService.findAll();
        model.addAttribute("events", eventList);
        return "views-base-home";}
    @RequestMapping (value = "/AdminMenu", method = RequestMethod.GET)
    public String Admin (){return "views-base-admin";}
}

