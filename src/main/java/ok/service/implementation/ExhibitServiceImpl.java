package ok.service.implementation;

import ok.dto.ExhibitDTO;
import ok.entity.Exhibit;
import ok.entity.ExhibitImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ok.repository.ExhibitRepo;
import ok.service.ExhibitService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Service
public class ExhibitServiceImpl implements ExhibitService {
@Autowired
    private ExhibitRepo exhibitRepo;

    public void addOrEdit(Exhibit exhibit) {
        exhibitRepo.save(exhibit);
    }

    public void delete(int id) {
        exhibitRepo.delete(id);
    }

    public Exhibit findOne(int id) {
        return exhibitRepo.findOne(id);
    }

    public void addOrEdit(String description, String timePeriod, String material, String origin, MultipartFile multipartFile) {
        Exhibit exhibit = new Exhibit();
        exhibit.setDescription(description);
        exhibit.setTimePeriod(timePeriod);
        exhibit.setMaterial(material);
        exhibit.setOrigin(origin);
        try {
            exhibit.setMiniature(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        exhibitRepo.save(exhibit);
    }

    public void edit(int id, String description, String timePeriod, String material, String origin, MultipartFile multipartFile) {
        Exhibit exhibit = exhibitRepo.findOne(id);
        exhibit.setDescription(description);
        exhibit.setTimePeriod(timePeriod);
        exhibit.setMaterial(material);
        exhibit.setOrigin(origin);
        try {
            exhibit.setMiniature(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        exhibitRepo.save(exhibit);
    }

    public List<ExhibitDTO> findAll() {
List<ExhibitDTO> exhibitDTOList = new ArrayList<ExhibitDTO>();
        List<Exhibit> exhibitList = exhibitRepo.findAll();
        for (Exhibit exhibit: exhibitList) {
            ExhibitDTO exhibitDTO = new ExhibitDTO();
            exhibitDTO.setId(exhibit.getId());
            exhibitDTO.setDescription(exhibit.getDescription());
            exhibitDTO.setTimePeriod(exhibit.getTimePeriod());
            exhibitDTO.setMaterial(exhibit.getMaterial());
            exhibitDTO.setOrigin(exhibit.getOrigin());
            String miniatire = Base64.getEncoder().encodeToString(exhibit.getMiniature());
            exhibitDTO.setMiniature(miniatire);
            exhibitDTOList.add(exhibitDTO);
        }
        return exhibitDTOList;
    }

  public void addImage(int id, MultipartFile multipartFile){
      Exhibit exhibit = exhibitRepo.findOne(id);
      ExhibitImage exhibitImage = new ExhibitImage();
      exhibitImage.setimage(Base64.getEncoder().encodeToString(exhibit.getMiniature()).getBytes());
      exhibit.getExhibitImageList().add(exhibitImage);
  }

//     public List<Exhibit> findAll() {
//        return exhibitRepo.findAll();
//    }
}
