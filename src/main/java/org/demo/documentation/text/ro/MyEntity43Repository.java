package org.demo.documentation.text.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity43Repository extends JpaRepository<MyEntity43, Long>, JpaSpecificationExecutor<MyEntity43> {

}