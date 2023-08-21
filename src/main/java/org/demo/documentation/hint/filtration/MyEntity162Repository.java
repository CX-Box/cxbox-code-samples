package org.demo.documentation.hint.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity162Repository extends JpaRepository<MyEntity162, Long>, JpaSpecificationExecutor<MyEntity162> {

}