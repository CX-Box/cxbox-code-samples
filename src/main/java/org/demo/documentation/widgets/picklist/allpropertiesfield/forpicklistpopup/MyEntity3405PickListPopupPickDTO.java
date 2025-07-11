package org.demo.documentation.widgets.picklist.allpropertiesfield.forpicklistpopup;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3405PickListPopupPickDTO extends DataResponseDTO {

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

    public MyEntity3405PickListPopupPickDTO(MyEntity3405PickListPopup entity) {
        this.id = entity.getId().toString();
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
