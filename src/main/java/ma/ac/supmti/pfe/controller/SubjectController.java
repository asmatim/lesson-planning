package ma.ac.supmti.pfe.controller;


import ma.ac.supmti.pfe.dto.SubjectDto;
import ma.ac.supmti.pfe.facade.ModuleFacade;
import ma.ac.supmti.pfe.facade.SubjectFacade;
import ma.ac.supmti.pfe.model.ModuleModel;
import ma.ac.supmti.pfe.model.SubjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectFacade subjectFacade;

    @Autowired
    private ModuleFacade moduleFacade;

    @RequestMapping("/create")
    public String showSubjectForm(Model model){
        String title = "Nouvelle matière";
        SubjectDto subject = new SubjectDto();
        final List<ModuleModel> modules = moduleFacade.findAllModules();
        model.addAttribute("subject", subject);
        model.addAttribute("title", title);
        model.addAttribute("modules", modules);
        return "/subject/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processSubjectroomForm(@ModelAttribute SubjectDto subjectDto){
        SubjectModel subject = subjectFacade.save(subjectDto);
        return "redirect:/subject/detail/" + subject.getId();
    }

    @RequestMapping("/detail/{subjectId}")
    public String showSubjectDetail(Model model, @PathVariable("subjectId") Long subjectId){
        SubjectModel subject = subjectFacade.getSubject(subjectId);
        String title = subject.getName();
        model.addAttribute("subject", subject);
        model.addAttribute("title", title);
        return "/subject/detail";
    }

    @RequestMapping("/delete/{subjectId}")
    public String removeClassroom(@PathVariable("subjectId") Long subjectId){
        subjectFacade.delete(subjectId);
        return "redirect:/subject/create";
    }

    @RequestMapping("/list")
    public String showSubjectList(Model model){
        String title = "Liste de matières";
        List<SubjectModel> subjects = subjectFacade.getAllSubjects();
        model.addAttribute("title", title);
        model.addAttribute("subjects", subjects);
        return "/subject/list";
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.POST)
    @ResponseBody
    public List<SubjectDto> getAllSubjects(@RequestParam("classId") Long classId){
        return subjectFacade.getAllSubjectsDtos(classId);
    }

}
