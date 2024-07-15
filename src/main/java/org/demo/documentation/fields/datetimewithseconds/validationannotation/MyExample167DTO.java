package org.demo.documentation.fields.datetimewithseconds.validationannotation;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

import static org.demo.documentation.fields.main.TextError.LESS_CURRENT_DATE;

@Getter
@Setter
@NoArgsConstructor
public class MyExample167DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateValueProvider.class)
	@Future(message = LESS_CURRENT_DATE)
	private LocalDateTime customField;

	public MyExample167DTO(MyEntity167 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}