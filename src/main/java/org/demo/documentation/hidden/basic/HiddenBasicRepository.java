package org.demo.documentation.hidden.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HiddenBasicRepository extends JpaRepository<HiddenBasic, Long>, JpaSpecificationExecutor<HiddenBasic> {

}