package org.demo.documentation.fields.dictionary.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity86Repository extends JpaRepository<MyEntity86, Long>, JpaSpecificationExecutor<MyEntity86> {

}