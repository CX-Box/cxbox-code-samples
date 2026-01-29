package org.demo.documentation.fields.time.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MyExampleBc4106Repository extends JpaRepository<MyExampleBc4106, Long>, JpaSpecificationExecutor<MyExampleBc4106> {


}
