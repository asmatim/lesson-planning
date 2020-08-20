package ma.ac.supmti.pfe.controller;

import ma.ac.supmti.pfe.dto.LessonDto;
import ma.ac.supmti.pfe.facade.LessonFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonFacade lessonFacade;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public LessonDto planLesson(LessonDto lessonDto) {
        return lessonFacade.save(lessonDto);
    }

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

}
