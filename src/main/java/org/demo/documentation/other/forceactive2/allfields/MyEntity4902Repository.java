package org.demo.documentation.other.forceactive2.allfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4902Repository extends JpaRepository<MyEntity4902, Long>, JpaSpecificationExecutor<MyEntity4902> {

}
