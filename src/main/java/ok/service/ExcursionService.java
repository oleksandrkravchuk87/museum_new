package ok.service;

import ok.entity.Excursion;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface ExcursionService {
    void addOrEdit (Excursion excursion);
    void delete (int id);
    Excursion findOne (int id);
    List<Excursion> findAll();
}
