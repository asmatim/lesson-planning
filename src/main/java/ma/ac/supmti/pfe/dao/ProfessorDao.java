package ma.ac.supmti.pfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ac.supmti.pfe.model.ProfessorModel;

@Repository
public interface ProfessorDao extends JpaRepository<ProfessorModel, Long> {

}
