package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.ModeratorDao;
import ma.ac.supmti.pfe.model.ModeratorModel;
import ma.ac.supmti.pfe.service.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeratorServiceImpl implements ModeratorService {

    @Autowired
    private ModeratorDao moderatorDao;

    @Override
    public ModeratorModel getModerator(String username) {
        return moderatorDao.findByUsername(username);
    }

}
