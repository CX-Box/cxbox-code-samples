package org.demo.documentation.feature.microservice.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity380External;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyExample380ExternalDTO implements Serializable {

    private String id;
    private String type;
    private String key;
    private String value;
    private Integer displayOrder;

    public MyExample380ExternalDTO(MyEntity380External entity) {
        this.id = entity.getId().toString();
        this.type = entity.getType();
        this.key = entity.getKey();
        this.value = entity.getValue();
        this.displayOrder = entity.getDisplayOrder();
    }
}
