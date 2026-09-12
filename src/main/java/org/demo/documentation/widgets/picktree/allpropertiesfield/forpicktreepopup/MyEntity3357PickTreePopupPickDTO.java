package org.demo.documentation.widgets.picktree.allpropertiesfield.forpicktreepopup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3357PickTreePopupPickDTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	private String customField;
	@SearchParameter(name = "customFieldColorSort")
	private String customFieldColorSort;
	@SearchParameter(name = "customFieldRequired")
	private String customFieldRequired;
	@SearchParameter(name = "customFieldColorValidation")
	private String customFieldColorValidation;
	@SearchParameter(name = "customFieldDrilldown")
	private String customFieldDrilldown;
	@SearchParameter(name = "customFieldColorConst", provider = BigDecimalValueProvider.class)
	private Long customFieldColorConst;
	@SearchParameter(name = "customFieldColor", provider = BigDecimalValueProvider.class)
	private Long customFieldColor;
	@SearchParameter(name = "customFieldPlaceholder")
	private String customFieldPlaceholder;

	public MyEntity3357PickTreePopupPickDTO(MyEntity3357PickTreePopup entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.customField = entity.getCustomField();
		this.customFieldColorSort = entity.getCustomFieldColorSort();
		this.customFieldRequired = entity.getCustomFieldRequired();
		this.customFieldColorValidation = entity.getCustomFieldColorValidation();
		this.customFieldDrilldown = entity.getCustomFieldDrilldown();
		this.customFieldColorConst = entity.getCustomFieldColorConst();
		this.customFieldColor = entity.getCustomFieldColor();
		this.customFieldPlaceholder = entity.getCustomFieldPlaceholder();
	}

}
