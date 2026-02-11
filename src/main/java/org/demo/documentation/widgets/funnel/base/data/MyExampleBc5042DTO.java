package org.demo.documentation.widgets.funnel.base.data;

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
public class MyExampleBc5042DTO extends DataResponseDTO {


	@SearchParameter(name = "customFieldNum", provider = BigDecimalValueProvider.class)
	private Long customFieldNum;

	public MyExampleBc5042DTO(MyExampleBc5042 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.customFieldNum = entity.getCustomFieldNum();
	}

}
