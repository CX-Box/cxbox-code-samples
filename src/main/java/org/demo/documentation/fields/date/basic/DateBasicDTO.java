package org.demo.documentation.fields.date.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DateBasicDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateValueProvider.class)
	private LocalDateTime customField;

	public DateBasicDTO(DateBasic entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}