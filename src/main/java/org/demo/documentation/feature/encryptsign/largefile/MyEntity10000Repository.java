package org.demo.documentation.feature.encryptsign.largefile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity10000Repository extends JpaRepository<Myexample10000, Long>, JpaSpecificationExecutor<Myexample10000> {

}
