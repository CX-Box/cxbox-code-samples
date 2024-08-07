package org.demo.documentation.feature.microservice.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3137;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3137DTO implements Serializable {

    private String id;
    private String customField;

    public MyExample3137DTO(MyEntity3137 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
