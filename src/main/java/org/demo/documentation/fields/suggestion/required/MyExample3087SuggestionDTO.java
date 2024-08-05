package org.demo.documentation.fields.suggestion.required;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3087SuggestionDTO extends DataResponseDTO {
    private String customFieldSuggestion;
    private LocalDateTime customFieldSuggestionDate;

    public MyExample3087SuggestionDTO(MyEntity3087OutServiceDTO entity) {
        this.id = entity.getId().toString();
        this.customFieldSuggestion = entity.getCustomFieldSuggestion();
        this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();
    }
}
