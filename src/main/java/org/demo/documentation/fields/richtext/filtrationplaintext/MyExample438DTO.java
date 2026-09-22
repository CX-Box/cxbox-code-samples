package org.demo.documentation.fields.richtext.filtrationplaintext;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample438DTO extends DataResponseDTO {

	/** The filter of this field compares only letters and digits: of the column and of the value the user typed. */
	@SearchParameter(name = "customFieldPlain", provider = PlainTextValueProvider.class)
	private String customField;

	public MyExample438DTO(MyEntity438 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}