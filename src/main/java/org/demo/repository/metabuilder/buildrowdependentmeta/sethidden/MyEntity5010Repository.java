package org.demo.repository.metabuilder.buildrowdependentmeta.sethidden;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5010Repository extends JpaRepository<MyEntity5010, Long>, JpaSpecificationExecutor<MyEntity5010> {

}
