package org.demo.documentation.picklist.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity125Repository extends JpaRepository<MyEntity125, Long>, JpaSpecificationExecutor<MyEntity125> {

}