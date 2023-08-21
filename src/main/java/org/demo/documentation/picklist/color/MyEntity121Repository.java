package org.demo.documentation.picklist.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity121Repository extends JpaRepository<MyEntity121, Long>, JpaSpecificationExecutor<MyEntity121> {

}