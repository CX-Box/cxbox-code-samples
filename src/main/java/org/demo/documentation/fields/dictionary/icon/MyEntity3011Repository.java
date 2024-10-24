package org.demo.documentation.fields.dictionary.icon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3011Repository extends JpaRepository<MyEntity3011, Long>, JpaSpecificationExecutor<MyEntity3011> {

}
