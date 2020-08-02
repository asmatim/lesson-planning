package ma.ac.supmti.pfe.controller;

import ma.ac.supmti.pfe.dto.ProfessorDto;
import ma.ac.supmti.pfe.facade.ProfessorFacade;
import ma.ac.supmti.pfe.model.ProfessorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorFacade professorFacade;

    @RequestMapping("/create")
    public String showProfForm(Model model){
        String title = "Nouveau Professeur";
        ProfessorDto professor = new ProfessorDto();
        model.addAttribute("professor", professor);
        model.addAttribute("title", title);
        return "/professor/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processProfForm(@ModelAttribute ProfessorDto professorDto){
        ProfessorModel professorModel = professorFacade.save(professorDto);
        return "redirect:/professor/detail/" + professorModel.getId();
    }

    @RequestMapping("/detail/{professorId}")
    public String showProfDetail(Model model, @PathVariable("professorId") Long professorId){
        ProfessorModel professorModel = professorFacade.getProfessor(professorId);
        String title = professorModel.getFirstName() + " " + professorModel.getLastName();
        model.addAttribute("professor", professorModel);
        model.addAttribute("title", title);
        return "/professor/detail";
    }

    @RequestMapping("/delete/{professorId}")
    public String removeProfessor(@PathVariable("professorId") Long professorId){
        professorFacade.delete(professorId);
        return "redirect:/professor/create";
    }

}
