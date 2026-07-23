package org.demo.documentation.widgets.picktreepopup.tree;

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
public class Myexample3261DTO extends DataResponseDTO {


	@SearchParameter(name = "department", provider = StringValueProvider.class)
	private String department;

	public Myexample3261DTO(Myexample3261 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.department = entity.getDepartment();
	}

}
