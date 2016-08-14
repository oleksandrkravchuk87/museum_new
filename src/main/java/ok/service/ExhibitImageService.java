package ok.service;

import ok.dto.ExhibitImageDTO;
import ok.entity.ExhibitImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface ExhibitImageService {
    void addOrEdit (ExhibitImage exhibitImage);
    void delete (int id);
    ExhibitImage findOne (int id);
  //  List<ExhibitImage> findAll();
   // void  addOrEdit (MultipartFile multipartFile);
    List<ExhibitImageDTO> findAll();
   List<ExhibitImageDTO> findAllImages(int id);
    void addOrEdit(int id, MultipartFile multipartFile);
}
