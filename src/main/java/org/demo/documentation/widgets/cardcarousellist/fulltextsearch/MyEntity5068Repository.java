package org.demo.documentation.widgets.cardcarousellist.fulltextsearch;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5068Repository extends JpaRepository<MyEntity5068, Long>, JpaSpecificationExecutor<MyEntity5068> {

	// --8<-- [start:getFullTextSearchSpecification]
	default Specification<MyEntity5068> getFullTextSearchSpecification(String value) {
		return (root, query, cb) -> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(MyEntity5068_.customField));
	}
	// --8<-- [end:getFullTextSearchSpecification]

}
