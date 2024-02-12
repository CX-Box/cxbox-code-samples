package org.demo.documentation.datetime.validationannotation;

import java.time.LocalDateTime;
import javax.validation.constraints.Future;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;

import static org.demo.documentation.main.TextError.LESS_CURRENT_DATE;

@Getter
@Setter
@NoArgsConstructor
public class MyExample166DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateTimeValueProvider.class)
	@Future(message = LESS_CURRENT_DATE)
	private LocalDateTime customField;

	public MyExample166DTO(MyEntity166 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}