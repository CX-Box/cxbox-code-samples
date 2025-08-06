package org.demo.documentation.widgets.filepreview.allpropertiesfield;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5002Repository extends JpaRepository<MyEntity5002, Long>, JpaSpecificationExecutor<MyEntity5002> {

}
