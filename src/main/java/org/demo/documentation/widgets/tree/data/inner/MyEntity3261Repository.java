package org.demo.documentation.widgets.tree.data.inner;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3261Repository extends JpaRepository<Myexample3261, Long>, JpaSpecificationExecutor<Myexample3261> {

	default Specification<Myexample3261> getFullTextSearchSpecification(String value) {
		return   getDepartmentLikeIgnoreCaseSpecification(value);
	}

	default Specification<Myexample3261> getDepartmentLikeIgnoreCaseSpecification(String value) {
		return (root, query, cb)
				-> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(Myexample3261_.department));
	}

}
