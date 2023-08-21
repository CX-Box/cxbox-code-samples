package org.demo.documentation.multipleselect.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity334Repository extends JpaRepository<MyEntity334, Long>, JpaSpecificationExecutor<MyEntity334> {

}