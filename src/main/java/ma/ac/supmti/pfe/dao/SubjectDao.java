package ma.ac.supmti.pfe.dao;

import ma.ac.supmti.pfe.model.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.ac.supmti.pfe.model.SubjectModel;

import java.util.List;

@Repository
public interface SubjectDao extends JpaRepository<SubjectModel, Long> {

    @Query("SELECT s FROM class as c INNER JOIN branch as b INNER JOIN module as m INNER JOIN subject as s WHERE c.id = :classId")
    List<SubjectModel> findByClass(ClassModel classModel);
}
