package org.demo.documentation.date.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateBasicRepository extends JpaRepository<DateBasic, Long>, JpaSpecificationExecutor<DateBasic> {

}