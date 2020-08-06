package ma.ac.supmti.pfe.facade;

import ma.ac.supmti.pfe.dto.ModuleDto;
import ma.ac.supmti.pfe.model.ModuleModel;

import java.util.List;

public interface ModuleFacade {

    ModuleModel save(ModuleDto moduleDto);

    void delete(ModuleDto moduleDto);

    void delete(Long moduleId);

    ModuleModel getModule(Long moduleId);

    List<ModuleModel> findAllModules();
}
