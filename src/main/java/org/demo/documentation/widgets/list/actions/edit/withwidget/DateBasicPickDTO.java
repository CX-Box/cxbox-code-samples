package org.demo.documentation.widgets.list.actions.edit.withwidget;

import java.time.LocalDateTime;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.demo.documentation.fields.date.basic.DateBasic;

@Getter
@Setter
@NoArgsConstructor
public class DateBasicPickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = DateValueProvider.class)
    private LocalDateTime customField;

    public DateBasicPickDTO(DateBasic entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
