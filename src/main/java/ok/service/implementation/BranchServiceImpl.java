package ok.service.implementation;

import ok.dto.BranchDTO;
import ok.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ok.repository.BranchRepo;
import ok.service.BranchService;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
/**
 * Created by OKK on 07.08.2016.
 */
@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepo branchRepo;

    public void addOrEdit(Branch branch){branchRepo.save(branch);}

    public void addOrEdit(String name, String address, String workingHours, String description, MultipartFile multipartFile) {
        Branch branch= new Branch();
        branch.setName(name);
        branch.setAddress(address);
        branch.setWorkingHours(workingHours);
        branch.setDescription(description);
        try {
            branch.setImage(multipartFile.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        branchRepo.save(branch);
    }
    public void edit(int id, String name, String address, String workingHours, String description, MultipartFile multipartFile) {
        Branch branch =branchRepo.findOne(id);
        branch.setName(name);
        branch.setAddress(address);
        branch.setWorkingHours(workingHours);
        branch.setDescription(description);
        try {
            branch.setImage(multipartFile.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        branchRepo.save(branch);
    }

    public void delete(int id) {
        branchRepo.delete(id);
    }

    public Branch findOne(int id) {
        return branchRepo.findOne(id);
    }

//    public void add(String name, String address, String workingHours, MultipartFile multipartFile) {
//        Branch branch= new Branch();
//        branch.setName(name);
//        branch.setAddress(address);
//        branch.setWorkingHours(workingHours);
//        try {
//            branch.setImage(multipartFile.getBytes());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        branchRepo.save(branch);
//    }

    public List<BranchDTO> findAll() {
        List<BranchDTO> branchDTOList =new ArrayList<BranchDTO>();
        List<Branch> branchList =branchRepo.findAll();
        for (Branch branch: branchList) {
        BranchDTO branchDTO =new BranchDTO();
            branchDTO.setId(branch.getId());
            branchDTO.setName(branch.getName());
            branchDTO.setAddress(branch.getAddress());
            branchDTO.setWorkingHours(branch.getWorkingHours());
            branchDTO.setDescription(branch.getDescription());
            String image = Base64.getEncoder().encodeToString(branch.getImage());
            branchDTO.setImage(image);
            branchDTOList.add(branchDTO);
        }
        return branchDTOList;
    }

//    public List<Branch> findAll() {
//        return branchRepo.findAll();
//    }


}



