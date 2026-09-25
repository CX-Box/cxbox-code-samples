package org.demo.documentation.widgets.additionalinfo.showcondition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4231DTO extends DataResponseDTO {

	public static final String TEXT = "Condition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

	public static final String TEXT2 = "Show condition - if Custom Field Num < 5 widget show.";

	private String customField;
	@SearchParameter(name = "customFieldNum", provider = BigDecimalValueProvider.class)
	private Long customFieldNum;
	private Boolean customFieldShowCondition;

	public MyExample4231DTO(MyEntity4231 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldNum = entity.getCustomFieldNum();
		this.customFieldShowCondition = entity.getCustomFieldNum() < 5;
	}
}
