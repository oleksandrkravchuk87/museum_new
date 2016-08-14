package ok.service.implementation;

import ok.entity.Excursion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ok.repository.ExcursionRepo;
import ok.service.ExcursionService;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Service
public class ExcursionServiceImpl implements ExcursionService {

    @Autowired
    private ExcursionRepo excursionRepo;
    public void addOrEdit(Excursion excursion){
        excursionRepo.save(excursion);
    }

    public void delete(int id) {
        excursionRepo.delete(id);
    }

    public Excursion findOne(int id) {
        return excursionRepo.findOne(id);
    }

    public List<Excursion> findAll() {
        return excursionRepo.findAll();
    }
}
