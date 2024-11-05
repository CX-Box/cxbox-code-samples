package org.demo.documentation.fields.dictionary.icon.assoc;

import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3012;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3012MultiRepository extends JpaRepository<MyEntity3012Multi, Long>, JpaSpecificationExecutor<MyEntity3012Multi> {

}
