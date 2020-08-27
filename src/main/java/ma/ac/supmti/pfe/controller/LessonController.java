package ma.ac.supmti.pfe.controller;

import ma.ac.supmti.pfe.dto.ClassDto;
import ma.ac.supmti.pfe.dto.ClassroomDto;
import ma.ac.supmti.pfe.dto.LessonDto;
import ma.ac.supmti.pfe.dto.ProfessorDto;
import ma.ac.supmti.pfe.facade.ClassFacade;
import ma.ac.supmti.pfe.facade.ClassroomFacade;
import ma.ac.supmti.pfe.facade.LessonFacade;
import ma.ac.supmti.pfe.facade.ProfessorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonFacade lessonFacade;

    @Autowired
    private ClassFacade classFacade;

    @Autowired
    private ProfessorFacade professorFacade;

    @Autowired
    private ClassroomFacade classroomFacade;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public LessonDto planLesson(LessonDto lessonDto) {
        return lessonFacade.save(lessonDto);
    }

    @RequestMapping("/show")
    public String show(Model model){
        String title = "Planification";
        LessonDto lessonDto = new LessonDto();
        List<ClassDto> classes = classFacade.getAllClassesDtos();
        List<ProfessorDto> professors = professorFacade.getAllProfessorsDtos();
        List<ClassroomDto> classrooms = classroomFacade.getAllClassroomsDtos();
        model.addAttribute("classes", classes);
        model.addAttribute("professors", professors);
        model.addAttribute("classrooms", classrooms);
        model.addAttribute("lessonDto", lessonDto);
        model.addAttribute("title", title);
        return "/lesson/plan";
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.POST)
    @ResponseBody
    public List<LessonDto> getAllLessonsForClass(@RequestParam("classId") Long classId) {
        return lessonFacade.getAllLessonDtos(classId);
    }

    @RequestMapping(value = "/get/{lessonId}")
    @ResponseBody
    public LessonDto getLesson(@PathVariable("lessonId") Long lessonId) {
        return lessonFacade.getLesson(lessonId);
    }

    @RequestMapping(value = "/delete/{lessonId}")
    @ResponseBody
    public LessonDto deleteLesson(@PathVariable("lessonId") Long lessonId) {
        return lessonFacade.deleteLesson(lessonId);
    }

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

}
