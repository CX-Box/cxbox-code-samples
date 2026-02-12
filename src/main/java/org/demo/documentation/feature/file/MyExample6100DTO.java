package org.demo.documentation.feature.file;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.feature.file.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6100DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldFile")
	private String customFieldFile;

	private String customFieldFileId;

	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;

	public MyExample6100DTO(MyEntity6100 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldFile = entity.getCustomFieldFile();
		this.customFieldFileId = entity.getCustomFieldFileId();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
	}
}
