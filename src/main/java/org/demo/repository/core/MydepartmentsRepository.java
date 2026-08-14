package org.demo.repository.core;

import org.demo.documentation.widgets.tree.any.data.departments.Mydepartments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MydepartmentsRepository extends JpaRepository<Mydepartments, Long>, JpaSpecificationExecutor<Mydepartments> {


}
