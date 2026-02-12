package org.demo.documentation.widgets.calendaryearlist.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExampleBc5039DTO extends DataResponseDTO {


	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	@SearchParameter(name = "startDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime startDateTime;

	@SearchParameter(name = "endDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime endDateTime;

	public MyExampleBc5039DTO(MyExampleBc5039 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.customField = entity.getCustomField();
		this.startDateTime = entity.getStartDateTime();
		this.endDateTime = entity.getEndDateTime();
	}

}
