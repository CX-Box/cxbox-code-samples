package org.demo.documentation.widgets.list.base.allfields.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3003MultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3003MultivalueDTO(org.demo.documentation.widgets.form.title.MyEntity3003 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
