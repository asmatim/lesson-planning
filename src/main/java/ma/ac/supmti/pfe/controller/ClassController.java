package ma.ac.supmti.pfe.controller;

import ma.ac.supmti.pfe.dto.ClassDto;
import ma.ac.supmti.pfe.facade.BranchFacade;
import ma.ac.supmti.pfe.facade.ClassFacade;
import ma.ac.supmti.pfe.model.BranchModel;
import ma.ac.supmti.pfe.model.ClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassFacade classFacade;

    @Autowired
    private BranchFacade branchFacade;

    @RequestMapping("/create")
    public String showClassForm(Model model){
        String title = "Nouvelle Classe";
        ClassDto classe = new ClassDto();
        final List<BranchModel> branches = branchFacade.findAllBranches();
        model.addAttribute("title", title);
        model.addAttribute("classe", classe);
        model.addAttribute("branches", branches);
        return "/class/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processClassForm(@ModelAttribute ClassDto classDto){
        ClassModel classe = classFacade.save(classDto);
        return "redirect:/class/detail/"+ classe.getId();
    }

    @RequestMapping("/detail/{classId}")
    public String showClassDetail(Model model, @PathVariable("classId") Long classId){
        ClassModel classe = classFacade.getOneClass(classId);
        String title = classe.getName();
        model.addAttribute("title", title);
        model.addAttribute("classe", classe);
        return "/class/detail";
    }
    
    @RequestMapping("/delete/{classId}")
    public String removeClass(Model model, @PathVariable("classId") Long classId){
        classFacade.delete(classId);
        return "redirect:/class/create";
    }

    @RequestMapping("/list")
    public String showClassList(Model model){
        String title = "List des classes";
        List<ClassModel> classes = classFacade.saveAllClasses();
        model.addAttribute("title", title);
        model.addAttribute("classes", classes);
        return "/class/list";
    }
}
