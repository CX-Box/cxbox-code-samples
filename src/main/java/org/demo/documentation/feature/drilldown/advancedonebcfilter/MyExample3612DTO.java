package org.demo.documentation.feature.drilldown.advancedonebcfilter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.feature.drilldown.advancedonebcfilter.enums.CustomFieldFilterDictionaryEnum;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3612DTO extends DataResponseDTO {

	private String customField;
	@SearchParameter(name = "customFieldFilterDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldFilterDate;
	@SearchParameter(name = "customFieldFilterDictionary", provider = EnumValueProvider.class)
	private CustomFieldFilterDictionaryEnum customFieldFilterDictionary;

	public MyExample3612DTO(MyEntity3612 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldFilterDate = entity.getCustomFieldFilterDate();
		this.customFieldFilterDictionary = entity.getCustomFieldFilterDictionary();
	}
}