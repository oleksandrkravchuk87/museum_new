package ok.controllers;


import ok.entity.User;
import ok.service.ExcursionRecordService;
import ok.validations.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ok.service.UserService;

import java.security.Principal;
import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private ExcursionRecordService excursionRecordService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    private String registration(Model model) {
        model.addAttribute("user", new User());
        return "views-user-registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            return "views-user-registration";
        }else{
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addOrEdit(user);
    }
        return "redirect:/";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String login() {
        return "views-user-login";
    }



    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String cabinet(Principal principal, Model model) {
       User user = userService.findOne(Integer.parseInt(principal.getName()));
        model.addAttribute("user", user);
        model.addAttribute("records", excursionRecordService.findByUser(user.getId()));

        return "views-user-cabinet";
    }
    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public String allUsers(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "views-user-all";
    }
    @RequestMapping (value = "/user/add", method = RequestMethod.GET)
    public String newuser (Model model){
        model.addAttribute("user", new User());
        return "views-user-add";
    }
    @RequestMapping (value = "/user/create", method = RequestMethod.POST)
    public String createuser (@ModelAttribute User user){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addOrEdit(user);
        return "redirect:/user/all";
    }
    @RequestMapping (value = "/user/cabinet/{id}",method = RequestMethod.GET)
    public String userPage (@PathVariable String id, Model model){
        User user = userService.findOne(Integer.parseInt(id));
        model.addAttribute("user", user);
        model.addAttribute("records", excursionRecordService.findByUser(Integer.parseInt(id)));
        return "views-user-cabinet";
    }



    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("user", userService.findOne(Integer.parseInt(id)));
        return "views-user-edit";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute User user) {
        userService.addOrEdit(user);
        return "redirect:/user/page/" + String.valueOf(user.getId());
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id) {
        userService.delete(Integer.parseInt(id));
        return "redirect:/user/all";
    }
}
