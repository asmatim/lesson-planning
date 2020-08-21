package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.ClassDto;
import ma.ac.supmti.pfe.facade.ClassFacade;
import ma.ac.supmti.pfe.model.BranchModel;
import ma.ac.supmti.pfe.model.ClassModel;
import ma.ac.supmti.pfe.service.BranchService;
import ma.ac.supmti.pfe.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassFacadeImp implements ClassFacade {

    @Autowired
    private ClassService classService;

    @Autowired
    private BranchService branchService;

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
    public List<ClassModel> getAllClasses() {
        return classService.findAllClasses();
    }

    @Override
    public List<ClassDto> getAllClassesDtos() {
        List<ClassModel> classes = classService.findAllClasses();
        return reverseConvertAll(classes);
    }

    private List<ClassDto> reverseConvertAll(List<ClassModel> classes) {
        List<ClassDto> classDtos = new ArrayList<>();
        for (ClassModel classModel : classes) {
            classDtos.add(reverseConvert(classModel));
        }
        return classDtos;
    }

    private ClassDto reverseConvert(ClassModel classModel) {
        ClassDto classDto = new ClassDto();
        classDto.setClassId(classModel.getId());
        classDto.setName(classModel.getName());
        return classDto;
    }

    private ClassModel convertClass(ClassDto classDto){
        final ClassModel classModel = new ClassModel();
        final BranchModel branchModel = branchService.getBranch(classDto.getBranchId());
        classModel.setName(classDto.getName());
        classModel.setYear(classDto.getYear());
        classModel.setBranch(branchModel);
        return classModel;
    }
}
