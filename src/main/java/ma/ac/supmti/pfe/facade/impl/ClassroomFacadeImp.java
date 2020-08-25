package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.ClassroomDto;
import ma.ac.supmti.pfe.facade.ClassroomFacade;
import ma.ac.supmti.pfe.model.ClassroomModel;
import ma.ac.supmti.pfe.service.ClassroomService;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    @Override
    public List<ClassroomDto> getAllClassroomsDtos() {
        List<ClassroomModel> classrooms = classroomService.findAllClasses();
        return reverseConvertAll(classrooms);
    }

    @Override
    public ClassroomDto getClassroomDto(Long classroomId) {
        ClassroomModel classroomModel = classroomService.getClassroom(classroomId);
        return reverseConvert(classroomModel);
    }

    private List<ClassroomDto> reverseConvertAll(List<ClassroomModel> classrooms) {
        List<ClassroomDto> classroomDtos = new ArrayList<>();
        for (ClassroomModel classroomModel:classrooms ) {
            classroomDtos.add(reverseConvert(classroomModel));
        }
        return classroomDtos;
    }

    private ClassroomDto reverseConvert(ClassroomModel classroomModel) {
        ClassroomDto classroomDto = new ClassroomDto();
        classroomDto.setClassroomId(classroomModel.getId());
        classroomDto.setName(classroomModel.getName());
        classroomDto.setCapacity(classroomModel.getCapacity());
        return classroomDto;
    }

    private ClassroomModel convertClassroom(ClassroomDto classroomDto){
        final ClassroomModel classroomModel = new ClassroomModel();
        classroomModel.setId(classroomDto.getClassroomId());
        classroomModel.setName(classroomDto.getName());
        classroomModel.setCapacity(classroomDto.getCapacity());
        return classroomModel;
    }
}
