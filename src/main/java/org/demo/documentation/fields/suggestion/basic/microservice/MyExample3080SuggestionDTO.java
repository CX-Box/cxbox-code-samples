package org.demo.documentation.fields.suggestion.basic.microservice;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3080SuggestionDTO extends DataResponseDTO {

    private String customFieldSuggestion;
    private LocalDateTime customFieldSuggestionDate;
    public MyExample3080SuggestionDTO(MyEntity3080OutServiceDTO entity) {
        this.id = entity.getId();
        this.customFieldSuggestion = entity.getCustomFieldSuggestion();
        this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();
    }
}