package org.demo.documentation.widgets.tree.data.departments;

import org.demo.conf.cxbox.extension.fulltextsearch.FullTextSearchExt;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
		ORDER BY mydept.id, u.id
		OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY
		""")
	List<DepartmentUsersPrj> allDepartmentUsers(@Param("offset") int offset, @Param("limit") int limit);

}
