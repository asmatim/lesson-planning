package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.ClassroomDto;
import ma.ac.supmti.pfe.facade.ClassroomFacade;
import ma.ac.supmti.pfe.model.ClassroomModel;
import ma.ac.supmti.pfe.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassroomFacadeImp implements ClassroomFacade {

    @Autowired
    ClassroomService classroomService;

    @Override
    public ClassroomModel save(ClassroomDto classroomDto) {
        ClassroomModel classroomModel = convertClassroom(classroomDto);
        return classroomService.save(classroomModel);
    }

    @Override
    public void delete(ClassroomDto classroomDto) {

    }

    @Override
    public void delete(Long classroomId) {
        classroomService.delete(classroomId);
    }

    @Override
    public List<ClassroomModel> findAllClasses() {
        return classroomService.findAllClasses();
    }

    @Override
    public ClassroomModel getClassroom(Long classroomId) {
        return classroomService.getClassroom(classroomId);
    }

    private ClassroomModel convertClassroom(ClassroomDto classroomDto){
        final ClassroomModel classroomModel = new ClassroomModel();
        classroomModel.setName(classroomDto.getName());
        classroomModel.setCapacity(classroomDto.getCapacity());
        return classroomModel;
    }
}
