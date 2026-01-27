package org.demo.documentation.fields.time.validationannotation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.TimeValueProvider;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4102DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = TimeValueProvider.class)
    @NotNull(message = "Custom message about error")
    private LocalDateTime customField;

    public MyExample4102DTO(MyEntity4102 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}