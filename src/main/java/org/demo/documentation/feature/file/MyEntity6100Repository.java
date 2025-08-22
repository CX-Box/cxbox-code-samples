package org.demo.documentation.feature.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity6100Repository extends JpaRepository<MyEntity6100, Long>, JpaSpecificationExecutor<MyEntity6100> {

}
