package org.demo.documentation.feature.microservice.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity4001;


import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4001DTO implements Serializable {

    private String id;
    private String customField;

    public MyExample4001DTO(MyEntity4001 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
