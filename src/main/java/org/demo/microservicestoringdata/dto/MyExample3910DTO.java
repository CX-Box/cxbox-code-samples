package org.demo.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.microservicestoringdata.repository.entity.MyEntity3910;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3910DTO implements Serializable {

    private String id;
    private String customField;
    private String customField2;
    public MyExample3910DTO(MyEntity3910 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
    }
}
