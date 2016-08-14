package ok.service;

import ok.entity.ExcursionRecord;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface ExcursionRecordService {
    void addOrEdit (ExcursionRecord excursionRecord);
    void delete (int id);
    ExcursionRecord findOne (int id);
    List<ExcursionRecord> findAll();
    void addOrEdit(int excursionId, String userId, String excursionDay, String excursionStart);
    List<ExcursionRecord> findByUser(int id);
}
