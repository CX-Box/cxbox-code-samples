package org.demo.documentation.feature.bulkupload;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3200DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customFieldFile", provider = StringValueProvider.class)
    private String customFieldFile;
    private String customFieldFileId;

    public MyExample3200DTO(MyEntity3200 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldFile = entity.getCustomFieldFile();
        this.customFieldFileId = entity.getCustomFieldFileId();
    }
}