package org.demo.documentation.fields.text.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity41Repository extends JpaRepository<MyEntity41, Long>, JpaSpecificationExecutor<MyEntity41> {

}