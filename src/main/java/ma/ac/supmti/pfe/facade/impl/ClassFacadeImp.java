package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.ClassDto;
import ma.ac.supmti.pfe.facade.ClassFacade;
import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassFacadeImp implements ClassFacade {

    @Autowired
    ClassService classService;

    @Override
    public ClassModel save(ClassDto classDto) {
        ClassModel  classModel = convertClass(classDto);
        return classService.save(classModel);
    }

    @Override
    public void delete(Long classId) { classService.delete(classId); }

    @Override
    public ClassModel getOneClass(Long classId) {
        return classService.getOneClass(classId);
    }

    @Override
    public List<ClassModel> saveAllClasses() {
        return classService.findAllClasses();
    }

    private ClassModel convertClass(ClassDto classDto){
        final ClassModel classModel = new ClassModel();
        classModel.setId(classDto.getClassId());
        classModel.setName(classDto.getName());
        classModel.setYear(classDto.getYear());
        return classModel;
    }
}
