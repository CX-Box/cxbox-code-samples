package org.demo.documentation.multifield.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity360Repository extends JpaRepository<MyEntity360, Long>, JpaSpecificationExecutor<MyEntity360> {

}