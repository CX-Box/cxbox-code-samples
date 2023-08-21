package org.demo.documentation.multivaluero.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity202Repository extends JpaRepository<MyEntity202, Long>, JpaSpecificationExecutor<MyEntity202> {

}