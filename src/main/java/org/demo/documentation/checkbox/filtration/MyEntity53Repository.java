package org.demo.documentation.checkbox.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity53Repository extends JpaRepository<MyEntity53, Long>, JpaSpecificationExecutor<MyEntity53> {

}