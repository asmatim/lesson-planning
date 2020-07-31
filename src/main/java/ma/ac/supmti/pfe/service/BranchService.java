package ma.ac.supmti.pfe.service;

import ma.ac.supmti.pfe.model.BranchModel;

public interface BranchService {

    BranchModel save(BranchModel branchModel);
    void delete(BranchModel branchModel);


}
