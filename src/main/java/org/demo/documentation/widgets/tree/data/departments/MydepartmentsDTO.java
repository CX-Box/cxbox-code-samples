package org.demo.documentation.widgets.tree.data.departments;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.data.users.My3261Users;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MydepartmentsDTO extends DataResponseDTO {


	@SearchParameter(name = "departmentName", provider = StringValueProvider.class)
	private String departmentName;

	@SearchParameter(name = "description", provider = StringValueProvider.class)
	private String description;

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	@SearchParameter(name = "fullNameList.id", provider = LongValueProvider.class)
	private MultivalueField fullName;

	private String fullNameDisplayedKey;

	public MydepartmentsDTO(Mydepartments entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.departmentName = entity.getDepartmentName();
		this.description = entity.getDescription();
		this.parentId = entity.getParentId();
		this.fullName = entity.getFullNameList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getLastName())
		));
		this.fullNameDisplayedKey = StringUtils.abbreviate(entity.getFullNameList().stream().map(My3261Users::getLastName
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
	}

}
