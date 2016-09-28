package ok.service;

import ok.dto.ExhibitDTO;
import ok.entity.Exhibit;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface ExhibitService {
    void addOrEdit (Exhibit exhibit);
    void delete(int id);

    Exhibit findOne(int id);

   // List<Exhibit> findAll();
    void  addOrEdit (String description, String timePeriod, String material, String origin, MultipartFile multipartFile);
    void  edit (int id, String description, String timePeriod, String material, String origin, MultipartFile multipartFile);
    List<ExhibitDTO> findAll();
    public void addImage(int id, MultipartFile multipartFile);
    List<ExhibitDTO> findByDesc(String description);
}

