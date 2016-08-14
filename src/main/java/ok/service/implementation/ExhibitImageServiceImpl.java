
package ok.service.implementation;

import ok.dto.ExhibitImageDTO;
import ok.entity.Exhibit;
import ok.entity.ExhibitImage;
import ok.repository.ExhibitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ok.repository.ExhibitImageRepo;
import ok.service.ExhibitImageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
/**
 * Created by OKK on 07.08.2016.
 */
@Service
public class ExhibitImageServiceImpl implements ExhibitImageService {

    @Autowired
    private ExhibitImageRepo exhibitImageRepo;
    @Autowired
    private ExhibitRepo exhibitRepo;

    public void addOrEdit(ExhibitImage exhibitImage) {
        exhibitImageRepo.save(exhibitImage);
    }

    public void delete(int id) {
      exhibitImageRepo.delete(id);
    }





    public ExhibitImage findOne(int id) {
        return exhibitImageRepo.findOne(id);
    }

    public void addOrEdit(int id, MultipartFile multipartFile) {
        Exhibit exhibit = exhibitRepo.findOne(id);
        ExhibitImage exhibitImage = new ExhibitImage();
        try {
            exhibitImage.setimage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        exhibitImage.setExhibit(exhibit);
        exhibit.getExhibitImageList().add(exhibitImage);
        exhibitRepo.save(exhibit);
    }

    public List<ExhibitImageDTO> findAll() {
        List<ExhibitImageDTO> exhibitImageDTOList = new ArrayList<ExhibitImageDTO>();
        List<ExhibitImage> exhibitImageList = exhibitImageRepo.findAll();
        for (ExhibitImage exhibitImage:exhibitImageList) {
            ExhibitImageDTO exhibitImageDTO= new ExhibitImageDTO();
            exhibitImageDTO.setId(exhibitImage.getId());
            String image = Base64.getEncoder().encodeToString(exhibitImage.getimage());
            exhibitImageDTO.setImage(image);
            exhibitImageDTOList.add(exhibitImageDTO);
        }
        return null;
    }
    public List<ExhibitImageDTO> findAllImages(int id){
        List<ExhibitImageDTO> exhibitImageDTOList = new ArrayList<ExhibitImageDTO>();
        List<ExhibitImage> exhibitImageList = exhibitImageRepo.findAll(id);
        for (ExhibitImage exhibitImage:exhibitImageList) {
            ExhibitImageDTO exhibitImageDTO= new ExhibitImageDTO();
            exhibitImageDTO.setId(exhibitImage.getId());
            String image = Base64.getEncoder().encodeToString(exhibitImage.getimage());
            exhibitImageDTO.setImage(image);
            exhibitImageDTOList.add(exhibitImageDTO);
        }
        return exhibitImageDTOList;
    }

//    public List<ExhibitImage> findAll() {
//        return exhibitImageRepo.findAll();
//    }

}
