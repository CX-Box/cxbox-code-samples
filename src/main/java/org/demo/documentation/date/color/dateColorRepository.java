package org.demo.documentation.date.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface dateColorRepository extends JpaRepository<dateColor, Long>, JpaSpecificationExecutor<dateColor> {

}