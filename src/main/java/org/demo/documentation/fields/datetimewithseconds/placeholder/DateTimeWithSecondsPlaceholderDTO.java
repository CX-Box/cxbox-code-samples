package org.demo.documentation.fields.datetimewithseconds.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsPlaceholderDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateTimeValueProvider.class)
	private LocalDateTime customField;

	public DateTimeWithSecondsPlaceholderDTO(DateTimeWithSecondsPlaceholderEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}