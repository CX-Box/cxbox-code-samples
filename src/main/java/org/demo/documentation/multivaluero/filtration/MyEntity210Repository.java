package org.demo.documentation.multivaluero.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity210Repository extends JpaRepository<MyEntity210, Long>, JpaSpecificationExecutor<MyEntity210> {

}