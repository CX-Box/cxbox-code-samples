package org.demo.documentation.fields.suggestion.color.colorcalc;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3082SuggestionDTO extends DataResponseDTO {

    private String customFieldColor;
    private String customFieldSuggestion;
    private LocalDateTime customFieldSuggestionDate;

    public MyExample3082SuggestionDTO(MyEntity3082OutServiceDTO entity) {
        this.id = entity.getId().toString();
        this.customFieldSuggestion = entity.getCustomFieldSuggestion();
        this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();
        this.customFieldColor = "#eda6a6";
    }
}