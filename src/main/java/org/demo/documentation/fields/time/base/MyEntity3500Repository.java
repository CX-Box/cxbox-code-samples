package org.demo.documentation.fields.time.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3500Repository extends JpaRepository<MyEntity3500, Long>, JpaSpecificationExecutor<MyEntity3500> {

}