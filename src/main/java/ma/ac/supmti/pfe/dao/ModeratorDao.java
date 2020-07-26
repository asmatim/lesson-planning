package ma.ac.supmti.pfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ac.supmti.pfe.model.ModeratorModel;

@Repository
public interface ModeratorDao extends JpaRepository<ModeratorModel, Long> {

}
