package org.demo.documentation.other.forceactive2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4901Repository extends JpaRepository<MyEntity4901, Long>, JpaSpecificationExecutor<MyEntity4901> {

}
