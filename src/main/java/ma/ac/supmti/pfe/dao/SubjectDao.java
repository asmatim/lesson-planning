package ma.ac.supmti.pfe.dao;

import ma.ac.supmti.pfe.model.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.ac.supmti.pfe.model.SubjectModel;

import java.util.List;

@Repository
public interface SubjectDao extends JpaRepository<SubjectModel, Long> {

    @Query("SELECT s FROM class as c INNER JOIN c.branch as b INNER JOIN b.modules m INNER JOIN m.subjects as s WHERE c = :class")
    List<SubjectModel> findByClass(@Param("class") ClassModel classModel);
}
