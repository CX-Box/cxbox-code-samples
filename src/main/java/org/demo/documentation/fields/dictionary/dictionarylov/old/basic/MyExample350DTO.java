package org.demo.documentation.fields.dictionary.dictionarylov.old.basic;


import static org.demo.documentation.fields.dictionary.dictionarylov.old.AdministeredDictionaryTypeOld.REGIONS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LovValueProvider;
import org.demo.documentation.fields.dictionary.dictionarylov.old.AdministeredDictionaryOld;

@Getter
@Setter
@NoArgsConstructor
public class MyExample350DTO extends DataResponseDTO {

	@SearchParameter(provider = LovValueProvider.class)
	@AdministeredDictionaryOld(REGIONS)
	private String customField;

	public MyExample350DTO(MyEntity350 entity) {
		this.id = entity.getId().toString();
		this.customField = REGIONS.lookupValue(entity.getCustomField());
	}

}