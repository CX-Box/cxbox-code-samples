package org.demo.documentation.fileupload.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity99Repository extends JpaRepository<MyEntity99, Long>, JpaSpecificationExecutor<MyEntity99> {

}