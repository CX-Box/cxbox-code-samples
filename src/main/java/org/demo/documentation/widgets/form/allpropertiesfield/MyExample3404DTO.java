package org.demo.documentation.widgets.form.allpropertiesfield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3404DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldPlaceholder")
	private String customFieldPlaceholder;
	@SearchParameter(name = "customFieldColor", provider = BigDecimalValueProvider.class)
	private Long customFieldColor;
	@SearchParameter(name = "customFieldColorConst", provider = BigDecimalValueProvider.class)
	private Long customFieldColorConst;
	@SearchParameter(name = "customFieldColorDrilldown")
	private String customFieldColorDrilldown;
	@SearchParameter(name = "customFieldColorValidation")
	private String customFieldColorValidation;
	@SearchParameter(name = "customFieldColorSort")
	private String customFieldColorSort;
	@SearchParameter(name = "customFieldRequired")
	private String customFieldRequired;

	public MyExample3404DTO(MyEntity3404 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldPlaceholder = entity.getCustomFieldPlaceholder();
		this.customFieldColor = entity.getCustomFieldColor();
		this.customFieldColorConst = entity.getCustomFieldColorConst();
		this.customFieldColorDrilldown = entity.getCustomFieldColorDrilldown();
		this.customFieldColorValidation = entity.getCustomFieldColorValidation();
		this.customFieldColorSort = entity.getCustomFieldColorSort();
		this.customFieldRequired = entity.getCustomFieldRequired();
	}
}