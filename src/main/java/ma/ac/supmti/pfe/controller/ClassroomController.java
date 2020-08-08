package ma.ac.supmti.pfe.controller;

import ma.ac.supmti.pfe.dto.ClassroomDto;
import ma.ac.supmti.pfe.dto.ModuleDto;
import ma.ac.supmti.pfe.facade.ClassroomFacade;
import ma.ac.supmti.pfe.model.ClassroomModel;
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
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    ClassroomFacade classroomFacade;

    @RequestMapping("/create")
    public String showClassroomForm(Model model){
        String title = "Nouvelle Salle";
        ClassroomDto classroom = new ClassroomDto();
        model.addAttribute("classroom", classroom);
        model.addAttribute("title", title);
        return "/classroom/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processClassroomForm(@ModelAttribute ClassroomDto classroomDto){
        ClassroomModel classroom = classroomFacade.save(classroomDto);
        return "redirect:/classroom/detail/" + classroom.getId();
    }

    @RequestMapping("/detail/{classroomId}")
    public String showClassroomDetail(Model model, @PathVariable("classroomId") Long classroomId){
        ClassroomModel classroom = classroomFacade.getClassroom(classroomId);
        String title = classroom.getName();
        model.addAttribute("classroom", classroom);
        model.addAttribute("title", title);
        return "/classroom/detail";
    }

    @RequestMapping("/delete/{classroomId}")
    public String removeClassroom(@PathVariable("classroomId") Long classroomId){
        classroomFacade.delete(classroomId);
        return "redirect:/classroom/create";
    }

    @RequestMapping("/list")
    public String showClassroomList(Model model){
        String title = "Liste des salles";
        List<ClassroomModel> classrooms = classroomFacade.findAllClasses();
        model.addAttribute("title", title);
        model.addAttribute("classrooms", classrooms);
        return "/classroom/list";
    }
}
