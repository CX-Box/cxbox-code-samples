package org.demo.documentation.getsatrted.postgres.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4000Repository extends JpaRepository<MyEntity4000, Long>, JpaSpecificationExecutor<MyEntity4000> {

}