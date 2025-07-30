package org.demo.documentation.screen.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5000Repository extends JpaRepository<MyEntity5000, Long>, JpaSpecificationExecutor<MyEntity5000> {

}
