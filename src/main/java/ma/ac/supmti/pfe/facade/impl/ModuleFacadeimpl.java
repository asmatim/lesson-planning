package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.ModuleDto;
import ma.ac.supmti.pfe.facade.ModuleFacade;
import ma.ac.supmti.pfe.model.BranchModel;
import ma.ac.supmti.pfe.model.ModuleModel;
import ma.ac.supmti.pfe.service.BranchService;
import ma.ac.supmti.pfe.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModuleFacadeimpl implements ModuleFacade {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private BranchService branchService;

    @Override
    public ModuleModel save(ModuleDto moduleDto) {
        ModuleModel moduleModel = convertModule(moduleDto);
        return moduleService.save(moduleModel);
    }

    @Override
    public void delete(ModuleDto moduleDto) {

    }

    @Override
    public void delete(Long moduleId) {
        moduleService.delete(moduleId);
    }

    @Override
    public ModuleModel getModule(Long moduleId) {
        return moduleService.getOne(moduleId);
    }

    @Override
    public List<ModuleModel> findAllModules() {
        return moduleService.findAllModules();
    }

    @Override
    public ModuleDto getModuleDto(Long moduleId) {
        ModuleModel moduleModel = moduleService.getOne(moduleId);
        return reverseConvertModule(moduleModel);
    }

    private ModuleDto reverseConvertModule(ModuleModel moduleModel) {
        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setModuleId(moduleModel.getId());
        moduleDto.setBranchId(moduleModel.getBranch().getId());
        moduleDto.setName(moduleModel.getName());
        return moduleDto;
    }

    private ModuleModel convertModule(ModuleDto moduleDto){
        final ModuleModel moduleModel = new ModuleModel();
        final BranchModel branchModel = branchService.getBranch(moduleDto.getBranchId());
        moduleModel.setName(moduleDto.getName());
        moduleModel.setBranch(branchModel);
        return moduleModel;
    }
}
