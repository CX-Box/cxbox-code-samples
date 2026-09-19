package org.demo.documentation.widgets.property.excel.filtration;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3138Repository extends JpaRepository<MyEntity3138, Long>, JpaSpecificationExecutor<MyEntity3138> {

	/** The fields named in the placeholder of the search field: Custom Field Input and Custom Field Text. */
	default Specification<MyEntity3138> getFullTextSearchSpecification(String value) {
		return (root, query, cb) -> cb.or(
				FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3138_.customFieldInput)),
				FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity3138_.customFieldText))
		);
	}

}
