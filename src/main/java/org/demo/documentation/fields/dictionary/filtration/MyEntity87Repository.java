package org.demo.documentation.fields.dictionary.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity87Repository extends JpaRepository<MyEntity87, Long>, JpaSpecificationExecutor<MyEntity87> {

}