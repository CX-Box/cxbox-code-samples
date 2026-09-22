package org.demo.documentation.fields.richtext.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity428Repository extends JpaRepository<MyEntity428, Long>, JpaSpecificationExecutor<MyEntity428> {

}