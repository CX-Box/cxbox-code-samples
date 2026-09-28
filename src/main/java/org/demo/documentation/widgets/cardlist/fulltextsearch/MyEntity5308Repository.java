package org.demo.documentation.widgets.cardlist.fulltextsearch;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5308Repository extends JpaRepository<MyEntity5308, Long>, JpaSpecificationExecutor<MyEntity5308> {

	// --8<-- [start:getFullTextSearchSpecification]
	default Specification<MyEntity5308> getFullTextSearchSpecification(String value) {
		return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity5308_.customField));
	}
	// --8<-- [end:getFullTextSearchSpecification]

}
