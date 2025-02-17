package org.demo.documentation.widgets.assoc.actions.other.createwithparent;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import org.demo.documentation.widgets.assoc.actions.other.createwithparent.assoc.MyEntity3662;
import org.demo.documentation.widgets.assoc.actions.other.createwithparent.assocreq.MyEntity3663;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3660DTO extends DataResponseDTO {


    @SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
    private MultivalueField customField;
    private String customFieldDisplayedKey;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;
    @SearchParameter(name = "customFieldTextReq")
    private String customFieldTextReq;
    @SearchParameter(name = "customFieldReqList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldReq;
    private String customFieldReqDisplayedKey;

    public MyExample3660DTO(MyEntity3660 entity) {
        this.id = entity.getId().toString();

        this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3662::getCustomField
        ));
        this.customFieldDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntity3662::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldText = entity.getCustomFieldText();

        this.customFieldTextReq = entity.getCustomFieldTextReq();
        this.customFieldReq = entity.getCustomFieldReqList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3663::getCustomField
        ));
        this.customFieldReqDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldReqList().stream().map(MyEntity3663::getCustomField
        ).collect(Collectors.joining(",")), 12);
    }
}