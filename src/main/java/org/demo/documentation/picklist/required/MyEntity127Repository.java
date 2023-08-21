package org.demo.documentation.picklist.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity127Repository extends JpaRepository<MyEntity127, Long>, JpaSpecificationExecutor<MyEntity127> {

}