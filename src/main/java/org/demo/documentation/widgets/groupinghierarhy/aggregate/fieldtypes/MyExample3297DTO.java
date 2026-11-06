package org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3297DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldNumber", provider = LongValueProvider.class)
	private Long customFieldNumber;

	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;

	@SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldPercent;

	@SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldDate;

	@SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldDateTime;

	@SearchParameter(name = "customFieldInput")
	private String customFieldInput;

	private String customFieldColor;

	public MyExample3297DTO(MyEntity3297 entity) {
		this.id = entity.getId().toString();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customField = entity.getCustomField();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldMoney = entity.getCustomFieldMoney();
		this.customFieldPercent = entity.getCustomFieldPercent();
		this.customFieldDate = entity.getCustomFieldDate();
		this.customFieldDateTime = entity.getCustomFieldDateTime();
		this.customFieldInput = entity.getCustomFieldInput();
		this.customFieldColor = entity.getCustomFieldColor();
	}

}
