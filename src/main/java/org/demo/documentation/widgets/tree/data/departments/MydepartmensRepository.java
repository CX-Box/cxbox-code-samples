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
		SELECT CONCAT(mydept.id, '-', COALESCE(u.id, 0)), 
				 mydept.parentId, 
				mydept.departmentName, 
				u.lastName, u.firstName, u.middleName,
				 CONCAT(u.lastName, ' ', u.firstName, ' ', u.middleName) AS fullName,
				 case when  mydept.parentId is null  then FALSE else TRUE end AS isLeaf
		FROM Mydepartments mydept
		LEFT JOIN mydept.fullNameList u
		ORDER BY mydept.id, u.id
		OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY
		""")
	List<DepartmentUsersPrj> allDepartmentUsers(@Param("offset") int offset, @Param("limit") int limit);

	@Query("""
    SELECT CONCAT(mydept.id, '-', COALESCE(u.id, 0)) AS Id,
           mydept.parentId AS parentId,
           mydept.departmentName AS departmentName,
           u.lastName AS lastName,
           u.firstName AS firstName,
           u.middleName AS middleName,
           CONCAT(u.lastName, ' ', u.firstName, ' ', u.middleName) AS fullName,
           CASE WHEN mydept.parentId IS NULL THEN FALSE ELSE TRUE END AS isLeaf
    FROM Mydepartments mydept
    LEFT JOIN mydept.fullNameList u
	WHERE (CASE WHEN mydept.parentId IS NULL THEN FALSE ELSE TRUE END) = :isLeaf
		ORDER BY mydept.id, u.id
		OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY
	""")
	List<DepartmentUsersPrj> allDepartmentUsersisLeaf(@Param("offset") int offset,
	                                                  @Param("limit") int limit,
	                                                  @Param("isLeaf") boolean isLeaf);

	@Query("""
    SELECT CONCAT(mydept.id, '-', COALESCE(u.id, 0)) AS Id,
           mydept.parentId AS parentId,
           mydept.departmentName AS departmentName,
           u.lastName AS lastName,
           u.firstName AS firstName,
           u.middleName AS middleName,
           CONCAT(u.lastName, ' ', u.firstName, ' ', u.middleName) AS fullName,
           CASE WHEN mydept.parentId IS NULL THEN FALSE ELSE TRUE END AS isLeaf
    FROM Mydepartments mydept
    LEFT JOIN mydept.fullNameList u
    WHERE mydept.id = :deptId
    ORDER BY mydept.id, u.id
    OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY
""")
	List<DepartmentUsersPrj> allDepartmentUsersDeptId(@Param("offset") int offset,
	                                                  @Param("limit") int limit,
	                                                  @Param("deptId") String deptId);
}