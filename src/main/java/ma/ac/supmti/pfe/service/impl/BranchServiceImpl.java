package ma.ac.supmti.pfe.service.impl;

import ma.ac.supmti.pfe.dao.BranchDao;
import ma.ac.supmti.pfe.model.BranchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ac.supmti.pfe.service.BranchService;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchDao branchDao;


    @Override
    public BranchModel save(BranchModel branchModel) {
        return branchDao.save(branchModel);
    }

    @Override
    public void delete(BranchModel branchModel) {
        branchDao.delete(branchModel);
    }

    @Override
    public void delete(Long branchId) { branchDao.deleteById(branchId); }

    @Override
    public BranchModel getBranch(Long branchId) {
        return branchDao.getOne(branchId);
    }

    @Override
    public List<BranchModel> findAllBranches() {
        return branchDao.findAll();
    }
}
