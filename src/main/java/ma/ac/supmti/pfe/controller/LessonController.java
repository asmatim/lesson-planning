package ma.ac.supmti.pfe.controller;

import ma.ac.supmti.pfe.dto.LessonDto;
import ma.ac.supmti.pfe.facade.LessonFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
