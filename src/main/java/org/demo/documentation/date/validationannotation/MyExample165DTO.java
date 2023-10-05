package org.demo.documentation.date.validationannotation;

import java.time.LocalDateTime;
import javax.validation.constraints.Future;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample165DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateValueProvider.class)
	@Future(message = "The field 'customField' cannot be less than the current date")
	private LocalDateTime  customField;

	public MyExample165DTO(MyEntity165 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}