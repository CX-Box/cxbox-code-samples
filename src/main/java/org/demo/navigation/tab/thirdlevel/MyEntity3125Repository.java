package org.demo.navigation.tab.thirdlevel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3125Repository extends JpaRepository<MyEntity3125, Long>, JpaSpecificationExecutor<MyEntity3125> {

}
