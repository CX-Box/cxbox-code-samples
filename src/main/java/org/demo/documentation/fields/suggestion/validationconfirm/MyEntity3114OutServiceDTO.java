package org.demo.documentation.fields.suggestion.validationconfirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3114OutServiceDTO implements Serializable {
    private String id;
    private String customFieldSuggestion;
    private LocalDateTime customFieldSuggestionDate;

}