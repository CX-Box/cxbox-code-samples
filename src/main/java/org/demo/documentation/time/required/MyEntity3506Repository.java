package org.demo.documentation.time.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3506Repository extends JpaRepository<MyEntity3506, Long>, JpaSpecificationExecutor<MyEntity3506> {

}