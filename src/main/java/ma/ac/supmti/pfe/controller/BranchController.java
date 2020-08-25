package ma.ac.supmti.pfe.controller;

import ma.ac.supmti.pfe.dto.BranchDto;
import ma.ac.supmti.pfe.facade.BranchFacade;
import ma.ac.supmti.pfe.model.BranchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchFacade branchFacade;

    @RequestMapping("/create")
    public String showBranchForm(Model model){
        String title = "Nouvelle Branche";
        BranchDto branch = new BranchDto();
        model.addAttribute("branch", branch);
        model.addAttribute("title", title);
        return "/branch/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processBranchForm(@ModelAttribute BranchDto branchDto){
        BranchModel branch = branchFacade.save(branchDto);
        return "redirect:/branch/detail/" + branch.getId();
    }

    @RequestMapping("/edit/{id}")
    public String showUpdateBranchForm(Model model, @PathVariable("id") Long branchId){
        String title = "Modifier Branche";
        BranchDto branch = branchFacade.getBranchDto(branchId);
        model.addAttribute("branch", branch);
        model.addAttribute("title", title);
        return "/branch/create";
    }

    @RequestMapping("/detail/{branchId}")
    public String showBranchDetail(Model model, @PathVariable("branchId") Long branchId){
        BranchModel branch = branchFacade.getBranch(branchId);
        String title = branch.getName();
        model.addAttribute("branch", branch);
        model.addAttribute("title", title);
        return "/branch/detail";
    }

    @RequestMapping("/delete/{branchId}")
    public String removeBranch(@PathVariable("branchId") Long branchId){
        branchFacade.delete(branchId);
        return "redirect:/branch/create";
    }

    @RequestMapping("/list")
    public String showBranchList(Model model){
        String title = "Liste des branches";
        List<BranchModel> branches = branchFacade.findAllBranches();
        model.addAttribute("title", title);
        model.addAttribute("branches", branches);
        return "/branch/list";
    }

}
