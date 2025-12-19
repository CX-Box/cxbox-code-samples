package org.demo.documentation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExampleBc832DTO extends DataResponseDTO {


    public MyExampleBc832DTO(MyExampleBc832 entity) {
        this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
    }

}
