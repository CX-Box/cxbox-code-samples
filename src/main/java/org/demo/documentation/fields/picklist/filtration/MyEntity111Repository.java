package org.demo.documentation.fields.picklist.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity111Repository extends JpaRepository<MyEntity111, Long>, JpaSpecificationExecutor<MyEntity111> {

}