package org.demo.documentation.feature.meta.buildindependentmeta.addconcretevalue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3152Repository extends JpaRepository<MyEntity3152, Long>, JpaSpecificationExecutor<MyEntity3152> {

}
