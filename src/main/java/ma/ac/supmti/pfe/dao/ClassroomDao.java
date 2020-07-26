package ma.ac.supmti.pfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ac.supmti.pfe.model.ClassroomModel;

@Repository
public interface ClassroomDao extends JpaRepository<ClassroomModel, Long> {

}
