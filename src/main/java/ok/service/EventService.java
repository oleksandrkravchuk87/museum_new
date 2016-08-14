package ok.service;

import ok.dto.EventDTO;
import ok.entity.Event;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface EventService {
    void addOrEdit (Event event);
    void delete (int id);
    Event findOne (int id);
   // List<Event> findAll();
   void  addOrEdit (String name, String description, String passingDate,  MultipartFile multipartFile);
    void  edit (int id, String name, String description, String passingDate,  MultipartFile multipartFile);
    List<EventDTO> findAll();
}
