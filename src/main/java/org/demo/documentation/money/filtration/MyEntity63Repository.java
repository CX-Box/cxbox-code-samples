package org.demo.documentation.money.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity63Repository extends JpaRepository<MyEntity63, Long>, JpaSpecificationExecutor<MyEntity63> {

}