package org.demo.documentation.widgets.tree.any.data.departments;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MydepartmentsDTO extends DataResponseDTO {


	@SearchParameter(name = "departmentName", provider = StringValueProvider.class)
	private String departmentName;

	public MydepartmentsDTO(Mydepartments entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.departmentName = entity.getDepartmentName();
	}

}
