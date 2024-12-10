package org.demo.documentation.fields.dictionary.dictionarydictionary.restapi;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.cxbox.dictionary.Dictionary;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MyEntity380ExternalRequest  implements Serializable {
    @NotNull
    private Class<Dictionary> type;

    private String key;

}