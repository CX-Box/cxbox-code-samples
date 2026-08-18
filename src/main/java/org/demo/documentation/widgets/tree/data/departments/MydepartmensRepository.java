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
public interface MydepartmensRepository extends JpaRepository<Mydepartments, Long>,
		JpaSpecificationExecutor<Mydepartments> {

	// ============ SPECIFICATIONS ============

	default Specification<Mydepartments> getFullTextSearchSpecification(String value) {
		return getDepartmentLikeIgnoreCaseSpecification(value);
	}

	default Specification<Mydepartments> getDepartmentLikeIgnoreCaseSpecification(String value) {
		return (root, query, cb) ->
				FullTextSearchExt.likeIgnoreCase(value, cb, root.get(Mydepartments_.departmentName));
	}

	// ============ QUERIES ============

	String BASE_SELECT = """
        SELECT CONCAT(mydept.id, '-', COALESCE(u.id, 0)) AS Id,
             CAST(mydept.parentId AS string) AS parentId,
               mydept.departmentName AS departmentName,
               u.lastName AS lastName,
               u.firstName AS firstName,
               u.middleName AS middleName,
               CONCAT(u.lastName, ' ', u.firstName, ' ', u.middleName) AS fullName,
               CASE WHEN mydept.parentId IS NULL THEN FALSE ELSE TRUE END AS isLeaf
        FROM Mydepartments mydept
        LEFT JOIN mydept.fullNameList u
    """;

	String ORDER_BY = " ORDER BY mydept.id, u.id ";
	String OFFSET_LIMIT = " OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY ";

	@Query(BASE_SELECT + ORDER_BY + OFFSET_LIMIT)
	List<DepartmentUsersPrj> allDepartmentUsers(@Param("offset") int offset,
	                                            @Param("limit") int limit);

	@Query(BASE_SELECT +
			" WHERE (CASE WHEN mydept.parentId IS NULL THEN FALSE ELSE TRUE END) = :isLeaf " +
			ORDER_BY + OFFSET_LIMIT)
	List<DepartmentUsersPrj> allDepartmentUsersisLeaf(@Param("offset") int offset,
	                                                  @Param("limit") int limit,
	                                                  @Param("isLeaf") boolean isLeaf);

	@Query(BASE_SELECT +
			" WHERE mydept.id = :deptId " +
			ORDER_BY + OFFSET_LIMIT)
	List<DepartmentUsersPrj> allDepartmentUsersDeptId(@Param("offset") int offset,
	                                                  @Param("limit") int limit,
	                                                  @Param("deptId") String deptId);

	@Query(BASE_SELECT +
			" WHERE mydept.parentId = :parentId " +
			ORDER_BY + OFFSET_LIMIT)
	List<DepartmentUsersPrj> allDepartmentUsersParentId(@Param("offset") int offset,
	                                                    @Param("limit") int limit,
	                                                    @Param("parentId") String parentId);
}