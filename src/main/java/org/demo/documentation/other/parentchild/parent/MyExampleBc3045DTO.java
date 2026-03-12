package org.demo.documentation.other.parentchild.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExampleBc3045DTO extends DataResponseDTO {


	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	private Long customField;

	private Boolean customFieldShowCondition;

	@SearchParameter(name = "customFieldDrilldown")
	private String customFieldDrilldown;

	public MyExampleBc3045DTO(MyExampleBc3045 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.customField = entity.getCustomField();
		this.customFieldShowCondition = entity.getCustomField() > 5;
		this.customFieldDrilldown = entity.getCustomFieldDrilldown();
	}

}
