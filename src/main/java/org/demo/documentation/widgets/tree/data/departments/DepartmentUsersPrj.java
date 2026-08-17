package org.demo.documentation.widgets.tree.data.departments;

public record DepartmentUsersPrj(
		String id,
		Long parentId,
		String departmentName,
		String lastName,
		String firstName,
		String middleName,
		String fullName,
		Boolean isLeaf
) {

}
