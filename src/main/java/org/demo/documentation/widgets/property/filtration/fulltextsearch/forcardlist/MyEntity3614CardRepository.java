package org.demo.documentation.widgets.property.filtration.fulltextsearch.forcardlist;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3614CardRepository extends JpaRepository<MyEntity3614Card, Long>, JpaSpecificationExecutor<MyEntity3614Card> {

	default Specification<MyEntity3614Card> getFullTextSearchSpecification(String value) {
		return getCustomFieldLikeIgnoreCaseSpecification(value)
				.or(getCustomFieldDescriptionLikeIgnoreCaseSpecification(value));
	}

	default Specification<MyEntity3614Card> getCustomFieldLikeIgnoreCaseSpecification(String value) {
		return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3614Card_.customField));
	}

	default Specification<MyEntity3614Card> getCustomFieldDescriptionLikeIgnoreCaseSpecification(String value) {
		return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3614Card_.customFieldDescription));
	}

}
