package org.demo.documentation.fileupload.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity103Repository extends JpaRepository<MyEntity103, Long>, JpaSpecificationExecutor<MyEntity103> {

}