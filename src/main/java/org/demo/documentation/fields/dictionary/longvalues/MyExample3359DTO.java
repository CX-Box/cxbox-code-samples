package org.demo.documentation.fields.dictionary.longvalues;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.dictionary.longvalues.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3359DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	@SearchParameter(name = "comment")
	private String comment;

	public MyExample3359DTO(MyEntity3359 entity) {
		this.id = entity.getId().toString();
		this.comment = entity.getComment();
		this.customField = entity.getCustomField();
	}

}