package org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3625Repository extends JpaRepository<MyEntity3625, Long>, JpaSpecificationExecutor<MyEntity3625> {
    default Specification<MyEntity3625> getCustomFieldLikeIgnoreCaseSpecification(String value) {
        return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3625_.customField));
    }

}
