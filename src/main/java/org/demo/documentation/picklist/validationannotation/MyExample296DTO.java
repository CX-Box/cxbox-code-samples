package org.demo.documentation.picklist.validationannotation;

import java.util.Optional;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import static org.demo.documentation.main.TextError.ONLY_LETTER;

@Getter
@Setter
@NoArgsConstructor
public class MyExample296DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldEntity.customField")
	@Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
	private String customField;

	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldId;

	public MyExample296DTO(MyEntity296 entity) {
		this.id = entity.getId().toString();
		this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}

}