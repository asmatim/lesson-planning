package ma.ac.supmti.pfe.facade.impl;

import ma.ac.supmti.pfe.dto.BranchDto;
import ma.ac.supmti.pfe.facade.BranchFacade;
import ma.ac.supmti.pfe.model.BranchModel;
import ma.ac.supmti.pfe.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class BranchFacadeImpl implements BranchFacade {

    @Autowired
    private BranchService branchService;


    @Override
    public BranchModel save(BranchDto branchDto) {
        BranchModel branchModel = convertBranch(branchDto);
        return branchService.save(branchModel);
    }

    @Override
    public void delete(BranchDto branchDto) {
        BranchModel branchModel = convertBranch((branchDto));
        branchService.delete(branchModel);
    }

    @Override
    public void delete(Long branchId) {
        branchService.delete(branchId);
    }

    @Override
    public BranchModel getBranch(Long branchId) {
        return branchService.getBranch(branchId);
    }

    @Override
    public List<BranchModel> findAllBranches() {
        return branchService.findAllBranches();
    }

    @Override
    public BranchDto getBranchDto(Long branchId) {
        final BranchModel branchModel = branchService.getBranch(branchId);
        return reverseConvertBranch(branchModel);
    }

    private BranchDto reverseConvertBranch(BranchModel branchModel) {
        final BranchDto branchDto = new BranchDto();
        branchDto.setBranchId(branchModel.getId());
        branchDto.setName(branchModel.getName());
        return branchDto;
    }

    private BranchModel convertBranch(BranchDto branchDto) {
        final BranchModel branchModel = new BranchModel();
        branchModel.setId(branchDto.getBranchId());
        branchModel.setName(branchDto.getName());
        return branchModel;
    }
}
