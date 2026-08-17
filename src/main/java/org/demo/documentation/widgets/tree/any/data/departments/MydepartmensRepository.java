package org.demo.documentation.widgets.tree.any.data.departments;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.demo.documentation.widgets.tree.tree.Myexample3261;
import org.demo.documentation.widgets.tree.tree.Myexample3261_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MydepartmensRepository extends JpaRepository<Mydepartments, Long>, JpaSpecificationExecutor<Mydepartments> {

	default Specification<Mydepartments> getFullTextSearchSpecification(String value) {
		return   getDepartmentLikeIgnoreCaseSpecification(value);
	}

	default Specification<Mydepartments> getDepartmentLikeIgnoreCaseSpecification(String value) {
		return (root, query, cb)
				-> FullTextSearchExt.likeIgnoreCase(value, cb, root.get(Mydepartments_.departmentName));
	}
	@Query("""
		SELECT CONCAT(mydept.id, '-', u.id), 
				 mydept.parentId, 
				mydept.departmentName, 
				u.lastName, u.firstName, u.middleName,
				 CONCAT(u.lastName, ' ', u.firstName, ' ', u.middleName) AS fullName,
				 CASE WHEN (SELECT COUNT(c) FROM Mydepartments c WHERE c.parentId = mydept.id) = 0
                    THEN true ELSE false END AS isLeaf
		FROM Mydepartments mydept
		JOIN mydept.fullNameList u
			""")
	List<DepartmentUsersPrj> allDepartmentUsers(
	);

}
