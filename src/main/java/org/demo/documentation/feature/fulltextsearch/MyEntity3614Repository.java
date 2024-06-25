package org.demo.documentation.feature.fulltextsearch;

import org.demo.conf.cxbox.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3614Repository extends JpaRepository<MyEntity3614, Long>, JpaSpecificationExecutor<MyEntity3614> {
    default Specification<MyEntity3614> getFullTextSearchSpecification(String value) {
        return getAddressLikeIgnoreCaseSpecification(value)
                .or(getFullNameLikeIgnoreCaseSpecification(value)
                        .or(getCustomFieldLikeIgnoreCaseSpecification(value)));
    }

    default Specification<MyEntity3614> getFullNameLikeIgnoreCaseSpecification(String value) {
        return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3614_.fullName));
    }


    default Specification<MyEntity3614> getAddressLikeIgnoreCaseSpecification(String value) {
        return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3614_.address));
    }

    default Specification<MyEntity3614> getCustomFieldLikeIgnoreCaseSpecification(String value) {
        return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3614_.customField));
    }
}
