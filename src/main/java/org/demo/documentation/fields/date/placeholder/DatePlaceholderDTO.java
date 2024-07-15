package org.demo.documentation.fields.date.placeholder;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class DatePlaceholderDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateValueProvider.class)
	private LocalDateTime  customField;

	public DatePlaceholderDTO(DatePlaceholderEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}