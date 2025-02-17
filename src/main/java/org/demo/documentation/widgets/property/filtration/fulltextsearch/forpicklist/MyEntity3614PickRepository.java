package org.demo.documentation.widgets.property.filtration.fulltextsearch.forpicklist;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3614PickRepository extends JpaRepository<MyEntity3614Pick, Long>, JpaSpecificationExecutor<MyEntity3614Pick> {
    default Specification<MyEntity3614Pick> getCustomFieldLikeIgnoreCaseSpecification(String value) {
        return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3614Pick_.customField));
    }
    default Specification<MyEntity3614Pick> getCustomFieldTextLikeIgnoreCaseSpecification(String value) {
        return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3614Pick_.customFieldText));
    }
    default Specification<MyEntity3614Pick> getFullTextSearchSpecification(String value) {
        return getCustomFieldLikeIgnoreCaseSpecification(value)
                .or(getCustomFieldTextLikeIgnoreCaseSpecification(value));
    }
}
