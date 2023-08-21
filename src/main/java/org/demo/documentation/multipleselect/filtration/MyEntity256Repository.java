package org.demo.documentation.multipleselect.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity256Repository extends JpaRepository<MyEntity256, Long>, JpaSpecificationExecutor<MyEntity256> {

}