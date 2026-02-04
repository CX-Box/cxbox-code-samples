package org.demo.documentation.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface EditLegalEntityRepository extends JpaRepository<EditLegalEntity, Long>, JpaSpecificationExecutor<EditLegalEntity> {


}
