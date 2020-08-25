package ma.ac.supmti.pfe.facade;

import ma.ac.supmti.pfe.dto.BranchDto;
import ma.ac.supmti.pfe.model.BranchModel;

import java.util.List;

public interface BranchFacade {

    BranchModel save(BranchDto branchDto);

    void delete(BranchDto branchDto);

    void delete(Long branchId);

    BranchModel getBranch(Long branchId);

    List<BranchModel> findAllBranches();

    BranchDto getBranchDto(Long branchId);
}
