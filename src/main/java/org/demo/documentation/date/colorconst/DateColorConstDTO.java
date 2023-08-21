package org.demo.documentation.date.colorconst;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class DateColorConstDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateValueProvider.class)
	private LocalDate customField;

	public DateColorConstDTO(dateColorConstEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}