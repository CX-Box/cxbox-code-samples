package org.demo.documentation.fields.dictionary.icon.assoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3011MultiRepository extends JpaRepository<MyEntity3011Multi, Long>, JpaSpecificationExecutor<MyEntity3011Multi> {

}
