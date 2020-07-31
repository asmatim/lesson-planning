package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.ModuleDao;
import ma.ac.supmti.pfe.model.ModuleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public ModuleModel save(ModuleModel moduleModel) {
        return moduleDao.save(moduleModel);
    }

    @Override
    public void delete(ModuleModel moduleModel) {
        moduleDao.delete(moduleModel);
    }
}
