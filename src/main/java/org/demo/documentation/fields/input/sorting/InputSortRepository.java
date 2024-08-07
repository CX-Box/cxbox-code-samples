package org.demo.documentation.fields.input.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputSortRepository extends JpaRepository<InputSort, Long>, JpaSpecificationExecutor<InputSort> {

}