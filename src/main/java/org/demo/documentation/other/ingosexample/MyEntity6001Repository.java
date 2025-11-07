package org.demo.documentation.other.ingosexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity6001Repository extends JpaRepository<MyEntity6001, Long>, JpaSpecificationExecutor<MyEntity6001> {

}
