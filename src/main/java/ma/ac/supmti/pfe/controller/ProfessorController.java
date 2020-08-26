package ma.ac.supmti.pfe.controller;

import ma.ac.supmti.pfe.dto.ClassDto;
import ma.ac.supmti.pfe.dto.ProfessorDto;
import ma.ac.supmti.pfe.dto.StatsDto;
import ma.ac.supmti.pfe.facade.ClassFacade;
import ma.ac.supmti.pfe.facade.ProfessorFacade;
import ma.ac.supmti.pfe.model.ProfessorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorFacade professorFacade;

    @Autowired
    private ClassFacade classFacade;

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

    @RequestMapping("/edit/{id}")
    public String showUpdateProfForm(Model model, @PathVariable("id") Long professorId){
        String title = "Modifier Professeur";
        ProfessorDto professor = professorFacade.getProfessorDto(professorId);
        model.addAttribute("professor", professor);
        model.addAttribute("title", title);
        return "/professor/create";
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

    @RequestMapping("/list")
    public String showProfessorList(Model model){
        String title = "Liste des professeurs";
        List<ProfessorModel> professors = professorFacade.getAllProfessors();
        model.addAttribute("title", title);
        model.addAttribute("professors", professors);
        return "/professor/list";
    }

    @RequestMapping("/stats/{id}")
    public String showProfStatsForm(Model model, @PathVariable("id") Long professorId){
        String title = "Statistiques Professeur";
        List<ClassDto> classes = classFacade.getAllClassesDtos();
        StatsDto statsDto = new StatsDto();
        statsDto.setProfessorId(professorId);
        model.addAttribute("stats", statsDto);
        model.addAttribute("classes", classes);
        model.addAttribute("title", title);
        return "/professor/stats";
    }

    @RequestMapping(value = "/stats", method = RequestMethod.POST)
    public String processProfStatsForm(Model model, StatsDto statsDto){
        String title = "Statistiques Professeur";
        List<ClassDto> classes = classFacade.getAllClassesDtos();
        StatsDto statsResult = professorFacade.getStatsFor(statsDto.getProfessorId(), statsDto.getClassId());
        model.addAttribute("stats", statsResult);
        model.addAttribute("classes", classes);
        model.addAttribute("title", title);
        return "/professor/stats";
    }

    @RequestMapping("/get/all")
    @ResponseBody
    public List<ProfessorDto> getAllProfessors(){
        return professorFacade.getAllProfessorsDtos();
    }

}
