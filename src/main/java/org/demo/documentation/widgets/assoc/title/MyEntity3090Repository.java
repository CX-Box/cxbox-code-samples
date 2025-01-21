package org.demo.documentation.widgets.assoc.title;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3090Repository extends JpaRepository<MyEntity3090, Long>, JpaSpecificationExecutor<MyEntity3090> {

}
