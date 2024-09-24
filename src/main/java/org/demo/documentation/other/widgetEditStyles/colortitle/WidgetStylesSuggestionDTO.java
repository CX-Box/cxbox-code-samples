package org.demo.documentation.other.widgetEditStyles.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class WidgetStylesSuggestionDTO extends DataResponseDTO {

    private String customFieldSuggestion;
    private LocalDateTime customFieldSuggestionDate;
    public WidgetStylesSuggestionDTO(WidgetStylesOutServiceDTO entity) {
        this.id = entity.getId().toString();
        this.customFieldSuggestion = entity.getCustomFieldSuggestion();
        this.customFieldSuggestionDate = entity.getCustomFieldSuggestionDate();
    }
}