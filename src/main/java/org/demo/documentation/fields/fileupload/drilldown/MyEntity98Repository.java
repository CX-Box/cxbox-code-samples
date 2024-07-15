package org.demo.documentation.fields.fileupload.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity98Repository extends JpaRepository<MyEntity98, Long>, JpaSpecificationExecutor<MyEntity98> {

}