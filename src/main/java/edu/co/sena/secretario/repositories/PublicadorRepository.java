package edu.co.sena.secretario.repositories;

import edu.co.sena.secretario.entities.PublicadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicadorRepository
    extends
    JpaRepository<PublicadorEntity, Long>,
    JpaSpecificationExecutor<PublicadorEntity> {
}
