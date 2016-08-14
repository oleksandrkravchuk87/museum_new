package ok.service.implementation;

import ok.entity.Excursion;
import ok.entity.ExcursionRecord;
import ok.entity.User;
import ok.repository.ExcursionRecordRepo;
import ok.repository.ExcursionRepo;
import ok.repository.UserRepo;
import ok.service.ExcursionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Service
public class ExcursionRecordServiceImpl implements ExcursionRecordService {
    @Autowired
    private ExcursionRecordRepo excursionRecordRepo;
    @Autowired
    private ExcursionRepo excursionRepo;

    @Autowired
    private UserRepo userRepo;

    public void addOrEdit(ExcursionRecord excursionRecord) {
        excursionRecordRepo.save(excursionRecord);
    }

    public void delete(int id) {
        excursionRecordRepo.delete(id);
    }

    public ExcursionRecord findOne(int id) {
        return excursionRecordRepo.findOne(id);
    }

    public List<ExcursionRecord> findAll() {
        return excursionRecordRepo.findAll();
    }


    public void addOrEdit(int excursionId, String userId, String excursionDay, String excursionStart) {

        ExcursionRecord excursionRecord = new ExcursionRecord();
        excursionRecord.setExcursionDay(excursionDay);
        excursionRecord.setExcursionStart(excursionStart);
        Excursion excursion = excursionRepo.findOne(excursionId);
        User user = userRepo.findOne(Integer.parseInt(userId));
        excursion.getExcursionRecordList().add(excursionRecord);
        user.getExcursionRecordList().add(excursionRecord);
        excursionRecord.setUser(user);
        excursionRecord.setExcursion(excursion);
        excursionRecordRepo.save(excursionRecord);
    }
    public List<ExcursionRecord> findByUser(int id) {
        return excursionRecordRepo.findByUser(id);
    }
}


