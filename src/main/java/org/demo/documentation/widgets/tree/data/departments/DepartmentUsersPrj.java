package org.demo.documentation.widgets.tree.data.departments;

import lombok.Builder;

@Builder
public record DepartmentUsersPrj(
		String id,
		String parentId,
		String departmentName,
		String lastName,
		String firstName,
		String middleName,
		String fullName,
		Boolean isLeaf
) { }

