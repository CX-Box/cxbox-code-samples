package org.demo.documentation.date.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface dateFiltrationEntityRepository extends JpaRepository<dateFiltrationEntity, Long>,
		JpaSpecificationExecutor<dateFiltrationEntity> {

}