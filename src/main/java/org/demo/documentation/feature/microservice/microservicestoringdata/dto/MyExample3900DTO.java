package org.demo.documentation.feature.microservice.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3900;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3900DTO implements Serializable {

    private String id;
    private String customField;
    private String customFieldNew;

    public MyExample3900DTO(MyEntity3900 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
    }
}
