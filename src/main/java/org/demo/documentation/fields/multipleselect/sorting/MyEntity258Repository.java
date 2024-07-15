package org.demo.documentation.fields.multipleselect.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity258Repository extends JpaRepository<MyEntity258, Long>, JpaSpecificationExecutor<MyEntity258> {

}