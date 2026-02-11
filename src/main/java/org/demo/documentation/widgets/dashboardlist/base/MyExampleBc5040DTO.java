package org.demo.documentation.widgets.dashboardlist.base;

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
public class MyExampleBc5040DTO extends DataResponseDTO {


	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	public MyExampleBc5040DTO(MyExampleBc5040 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.customField = entity.getCustomField();
	}

}
