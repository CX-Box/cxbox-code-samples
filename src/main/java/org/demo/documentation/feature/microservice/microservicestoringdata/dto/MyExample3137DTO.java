package org.demo.documentation.feature.microservice.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3137;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3137DTO implements Serializable {

    private String id;
    private String customField;
    private String customFieldNew;
    private LocalDateTime customFieldDateTime;
    private Double customFieldDouble;
    private String parentId;
    public MyExample3137DTO(MyEntity3137 entity) {
        this.id = entity.getId().toString();
        this.parentId = entity.getParentId();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
        this.customFieldDouble = entity.getCustomFieldDouble();
    }
}
