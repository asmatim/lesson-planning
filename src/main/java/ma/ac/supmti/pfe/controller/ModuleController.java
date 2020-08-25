package ma.ac.supmti.pfe.controller;

import ma.ac.supmti.pfe.dto.ModuleDto;
import ma.ac.supmti.pfe.facade.BranchFacade;
import ma.ac.supmti.pfe.facade.ModuleFacade;
import ma.ac.supmti.pfe.model.BranchModel;
import ma.ac.supmti.pfe.model.ModuleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleFacade moduleFacade;

    @Autowired
    private BranchFacade branchFacade;

    @RequestMapping("/create")
    public String showModuleForm(Model model){
        String title = "Nouveau Module";
        ModuleDto module = new ModuleDto();
        List<BranchModel> branches = branchFacade.findAllBranches();
        model.addAttribute("module", module);
        model.addAttribute("title", title);
        model.addAttribute("branches", branches);
        return "/module/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processModuleForm(@ModelAttribute ModuleDto moduleDto){
        ModuleModel module = moduleFacade.save(moduleDto);
        return "redirect:/module/detail/" + module.getId();
    }

    @RequestMapping("/edit/{id}")
    public String showUpdateModuleForm(Model model, @PathVariable("id") Long moduleId){
        String title = "Modifier Module";
        ModuleDto module = moduleFacade.getModuleDto(moduleId);
        List<BranchModel> branches = branchFacade.findAllBranches();
        model.addAttribute("module", module);
        model.addAttribute("title", title);
        model.addAttribute("branches", branches);
        return "/module/create";
    }

    @RequestMapping("/detail/{moduleId}")
    public String showModuleDetail(Model model, @PathVariable("moduleId") Long moduleId){
        ModuleModel module = moduleFacade.getModule(moduleId);
        String title = module.getName();
        model.addAttribute("module", module);
        model.addAttribute("title", title);
        return "/module/detail";
    }

    @RequestMapping("/delete/{moduleId}")
    public String removeModule(@PathVariable("moduleId") Long moduleId){
        moduleFacade.delete(moduleId);
        return "redirect:/module/create";
    }

    @RequestMapping("/list")
    public String showModuleList(Model model){
        String title = "Liste des modules";
        List<ModuleModel> modules = moduleFacade.findAllModules();
        model.addAttribute("title", title);
        model.addAttribute("modules", modules);
        return "/module/list";
    }
}
