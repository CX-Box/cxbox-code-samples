package org.demo.documentation.fields.datetime.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DateTimePlaceholderDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	private LocalDateTime customField;

	public DateTimePlaceholderDTO(DateTimePlaceholderEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}