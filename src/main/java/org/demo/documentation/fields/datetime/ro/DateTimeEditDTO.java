package org.demo.documentation.fields.datetime.ro;

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
public class DateTimeEditDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateTimeValueProvider.class)
	private LocalDateTime customField;

	public DateTimeEditDTO(DateTimeEdit entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}