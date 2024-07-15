package org.demo.documentation.feature.microservice.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3910;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3910DTO implements Serializable {

    private String id;
    private String customField;
    private String customFieldNew;
    private LocalDateTime customFieldDateTime;
    public MyExample3910DTO(MyEntity3910 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
    }
}
