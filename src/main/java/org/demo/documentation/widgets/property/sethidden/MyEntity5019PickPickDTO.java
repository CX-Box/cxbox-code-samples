package org.demo.documentation.widgets.property.sethidden;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum2;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity5019PickPickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum2 customFieldDictionary;

	public MyEntity5019PickPickDTO(MyEntity5019Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
	}

}
