package org.demo.documentation.fields.time.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3508DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = DateValueProvider.class)
    private LocalDateTime customField;
    @SearchParameter(name = "customFieldhmm", provider = DateValueProvider.class)
    private LocalDateTime customFieldhmm;
    @SearchParameter(name = "customFieldh", provider = DateValueProvider.class)
    private LocalDateTime customFieldh;
    @SearchParameter(name = "customFieldhmmA", provider = DateValueProvider.class)
    private LocalDateTime customFieldhmmA;
    @SearchParameter(name = "customFieldhmmssA", provider = DateValueProvider.class)
    private LocalDateTime customFieldhmmssA;
    @SearchParameter(name = "customFieldmm", provider = DateValueProvider.class)
    private LocalDateTime customFieldmm;
    @SearchParameter(name = "customFieldmmss", provider = DateValueProvider.class)
    private LocalDateTime customFieldmmss;
    @SearchParameter(name = "customFieldss", provider = DateValueProvider.class)
    private LocalDateTime customFieldss;
    public MyExample3508DTO(MyEntity3508 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldhmm = entity.getCustomFieldhmm();
        this.customFieldh = entity.getCustomFieldh();
        this.customFieldhmmA = entity.getCustomFieldhmmA();
        this.customFieldhmmssA = entity.getCustomFieldhmmssA();
        this.customFieldmm = entity.getCustomFieldmm();
        this.customFieldmmss = entity.getCustomFieldmmss();
        this.customFieldss = entity.getCustomFieldss();
    }
}