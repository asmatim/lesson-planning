package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.BranchModel;

import java.util.List;

public interface BranchService {

    BranchModel save(BranchModel branchModel);
    void delete(BranchModel branchModel);
    void delete(Long branchId);
    BranchModel getBranch(Long branchId);
    public List<BranchModel> findAllBranches();


}
