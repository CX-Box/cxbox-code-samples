package org.demo.documentation.radio.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity25Repository extends JpaRepository<MyEntity25, Long>, JpaSpecificationExecutor<MyEntity25> {

}