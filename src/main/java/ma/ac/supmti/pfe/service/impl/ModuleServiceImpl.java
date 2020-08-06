package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.ModuleDao;
import ma.ac.supmti.pfe.model.ModuleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.ModuleService;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public ModuleModel save(ModuleModel moduleModel) {
        return moduleDao.save(moduleModel);
    }

    @Override
    public void delete(Long moduleId) {
        moduleDao.deleteById(moduleId);
    }

    @Override
    public List<ModuleModel> findAllModules() {
        return moduleDao.findAll();
    }

    @Override
    public ModuleModel getOne(Long moduleId) {
        return moduleDao.getOne(moduleId);
    }
}
