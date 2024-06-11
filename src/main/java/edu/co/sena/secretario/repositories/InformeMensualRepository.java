package edu.co.sena.secretario.repositories;

import edu.co.sena.secretario.entities.InformeMensualEntity;
import edu.co.sena.secretario.entities.InformeMensualId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformeMensualRepository extends JpaRepository<InformeMensualEntity, InformeMensualId> {
    List<InformeMensualEntity> findByPublicadorId(Long publicadorId);
}
