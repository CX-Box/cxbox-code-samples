package org.demo.documentation.feature.drilldown.advancedfulltextsearchfilter;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3615Repository extends JpaRepository<MyEntity3615, Long>, JpaSpecificationExecutor<MyEntity3615> {
    default Specification<MyEntity3615> getFullTextSearchSpecification(String value) {
        return getAddressLikeIgnoreCaseSpecification(value)
                .or(getFullNameLikeIgnoreCaseSpecification(value)
                        .or(getCustomFieldLikeIgnoreCaseSpecification(value)));
    }

    default Specification<MyEntity3615> getFullNameLikeIgnoreCaseSpecification(String value) {
        return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3615_.fullName));
    }


    default Specification<MyEntity3615> getAddressLikeIgnoreCaseSpecification(String value) {
        return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3615_.address));
    }

    default Specification<MyEntity3615> getCustomFieldLikeIgnoreCaseSpecification(String value) {
        return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3615_.customField));
    }
}
