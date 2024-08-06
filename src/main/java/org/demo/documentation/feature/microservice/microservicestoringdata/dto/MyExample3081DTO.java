package org.demo.documentation.feature.microservice.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3081;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3081DTO implements Serializable {

    private String id;
    private String customFieldSuggestion;
    private LocalDateTime customFieldSuggestionDate;

    public MyExample3081DTO(MyEntity3081 entity) {
        this.id = entity.getId().toString();
        this.customFieldSuggestion = entity.getCustomFieldSuggestion();
        this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();
    }
}
