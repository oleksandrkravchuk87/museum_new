package ok.service;

import ok.dto.BranchDTO;
import ok.entity.Branch;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface BranchService {
    void addOrEdit(Branch branch);

    void addOrEdit(String name, String address, String workingHours, String description, MultipartFile multipartFile);
    void edit(int id, String name, String address, String workingHours, String description, MultipartFile multipartFile);
    void delete(int id);

    Branch findOne(int id);

    //  List<Branch> findAll();

    //   void add(String name, String address, String workingHours, MultipartFile multipartFile);

    List<BranchDTO> findAll();
}
