package ok.controllers;

import ok.entity.Branch;
import ok.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by OKK on 07.08.2016.
 */
@Controller
public class BranchController {
    @Autowired
    private BranchService branchService;

    @RequestMapping(value = "/branch/all", method = RequestMethod.GET)
    public String allBranches(Model model) {

        model.addAttribute("branches", branchService.findAll());
        return "views-branch-all";
    }
@RequestMapping (value = "/branch/add", method = RequestMethod.GET)
    public String newBranch (Model model){
        model.addAttribute("branch", new Branch());
        return "views-branch-add";
    }


@RequestMapping (value = "/branch/new", method = RequestMethod.POST)
    public String createBranch (@RequestParam("name")String name, @RequestParam("address")String address, @RequestParam("workingHours")String workingHours, @RequestParam("description")String description, @RequestParam("image")MultipartFile multipartFile){
        branchService.addOrEdit(name, address, workingHours, description, multipartFile);
        return "redirect:/branch/all";
    }


    @RequestMapping (value = "/branch/page/{id}",method = RequestMethod.GET)
    public String branchPage (@PathVariable String id, Model model){
        Branch branch = branchService.findOne(Integer.parseInt(id));
        model.addAttribute("branch", branch);
        return "views-branch-page";
    }
    @RequestMapping(value = "/branch/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("branch", branchService.findOne(Integer.parseInt(id)));
        return "views-branch-edit";
    }

    @RequestMapping(value = "/branch/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id")int id, @RequestParam("name")String name, @RequestParam("address")String address, @RequestParam("workingHours")String workingHours, @RequestParam("description")String description, @RequestParam("image")MultipartFile multipartFile) {
        branchService.edit(id, name, address, workingHours, description, multipartFile);
        return "redirect:/branch/all";
    }

    @RequestMapping(value = "/branch/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable String id) {
        branchService.delete(Integer.parseInt(id));
        return "redirect:/branch/all";
    }



}

