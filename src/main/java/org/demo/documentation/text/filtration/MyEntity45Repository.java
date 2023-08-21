package org.demo.documentation.text.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity45Repository extends JpaRepository<MyEntity45, Long>, JpaSpecificationExecutor<MyEntity45> {

}