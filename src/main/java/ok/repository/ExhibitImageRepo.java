package ok.repository;

import ok.entity.ExhibitImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface ExhibitImageRepo extends JpaRepository<ExhibitImage, Integer> {

    @Query("SELECT i FROM ExhibitImage i WHERE i.exhibit.id = :id")
    List<ExhibitImage> findAll(@Param("id") int id);

//    @Query("DELETE FROM ExhibitImage WHERE ExhibitImage.id = :id")
//    void delete(@Param("id") int id);


}
