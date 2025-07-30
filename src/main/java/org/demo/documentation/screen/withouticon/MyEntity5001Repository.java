package org.demo.documentation.screen.withouticon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5001Repository extends JpaRepository<MyEntity5001, Long>, JpaSpecificationExecutor<MyEntity5001> {

}
