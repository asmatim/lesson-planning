package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ModuleModel;

import java.util.List;

public interface ModuleService {

    ModuleModel save(ModuleModel moduleModel);
    void delete(Long moduleModel);

    List<ModuleModel> findAllModules();

    ModuleModel getOne(Long moduleId);
}
