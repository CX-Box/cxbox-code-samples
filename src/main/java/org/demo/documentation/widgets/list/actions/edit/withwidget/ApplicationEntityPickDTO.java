package org.demo.documentation.widgets.list.actions.edit.withwidget;

import java.lang.String;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationEntityPickDTO extends DataResponseDTO {

    @SearchParameter(name = "name", provider = StringValueProvider.class)
    private String name;

    public ApplicationEntityPickDTO(ApplicationEntity entity) {
        this.id = entity.getId().toString();
        this.name = entity.getName();
    }

}
