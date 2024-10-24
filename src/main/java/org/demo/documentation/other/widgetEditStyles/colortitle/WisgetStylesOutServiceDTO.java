package org.demo.documentation.other.widgetEditStyles.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class WisgetStylesOutServiceDTO implements Serializable {

    private String id;
    private String customFieldSuggestion;
    private LocalDateTime customFieldSuggestionDate;
}