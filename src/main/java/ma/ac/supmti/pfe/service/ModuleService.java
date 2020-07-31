package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.ModuleModel;

public interface ModuleService {

    ModuleModel save(ModuleModel moduleModel);
    void delete(ModuleModel moduleModel);

}
