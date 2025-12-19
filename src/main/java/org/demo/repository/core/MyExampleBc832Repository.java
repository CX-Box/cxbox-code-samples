package org.demo.repository.core;

import org.demo.documentation.MyExampleBc832;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MyExampleBc832Repository extends JpaRepository<MyExampleBc832, Long>, JpaSpecificationExecutor<MyExampleBc832> {


}
