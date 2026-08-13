package org.demo.documentation.widgets.tree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.tree.Myexample3261;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3260DTO extends DataResponseDTO {


	@SearchParameter(name = "departmentEntity.department")
	private String department;

	@SearchParameter(name = "departmentEntity.id", provider = LongValueProvider.class)
	private Long departmentId;

	@SearchParameter(name = "departmentsList.id", provider = LongValueProvider.class)
	private MultivalueField departments;

	private String departmentsDisplayedKey;

	public Myexample3260DTO(Myexample3260 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.departmentId = Optional.ofNullable(entity.getDepartmentEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.department = Optional.ofNullable(entity.getDepartmentEntity())
				.map(e -> e.getDepartment())
				.orElse(null);
		this.departments = entity.getDepartmentsList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getDepartment())
		));
		this.departmentsDisplayedKey = StringUtils.abbreviate(entity.getDepartmentsList().stream().map(Myexample3261::getDepartment
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
	}

}
