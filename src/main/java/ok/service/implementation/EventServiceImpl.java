package ok.service.implementation;

import ok.dto.EventDTO;
import ok.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ok.repository.EventRepo;
import ok.service.EventService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepo eventRepo;

    public void addOrEdit(Event event) {
        eventRepo.save(event);
    }

    public void delete(int id) {
        eventRepo.delete(id);
    }

    public Event findOne(int id) {
        return eventRepo.findOne(id);
    }

    public void addOrEdit(String name, String description, String passingDate, MultipartFile multipartFile) {
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);
        event.setPassingDate(passingDate);
        try {
            event.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        eventRepo.save(event);
    }

    public void edit(int id, String name, String description, String passingDate, MultipartFile multipartFile) {
        Event event = eventRepo.findOne(id);
        event.setName(name);
        event.setDescription(description);
        event.setPassingDate(passingDate);
        try {
            event.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        eventRepo.save(event);
    }

    public List<EventDTO> findAll() {
        List<EventDTO> eventDTOList = new ArrayList<EventDTO>();
        List<Event> eventList = eventRepo.findAll();
        for (Event event : eventList) {
            EventDTO eventDTO = new EventDTO();
            eventDTO.setId(event.getId());
            eventDTO.setName(event.getName());
            eventDTO.setDescription(event.getDescription());
            eventDTO.setPassingDate(event.getPassingDate());
            String image = Base64.getEncoder().encodeToString(event.getImage());
            eventDTO.setImage(image);
            eventDTOList.add(eventDTO);

        }
        return eventDTOList;
    }

    //  public List<Event> findAll() {
 //   return eventRepo.findAll();
}

