package org.demo.documentation.other.savewithparent.example2.child;

import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity4001;
import org.demo.documentation.other.savewithparent.example2.parent.MyEntity3131;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyEntity3130Repository extends JpaRepository<MyEntity3130, Long>, JpaSpecificationExecutor<MyEntity3130> {

}
