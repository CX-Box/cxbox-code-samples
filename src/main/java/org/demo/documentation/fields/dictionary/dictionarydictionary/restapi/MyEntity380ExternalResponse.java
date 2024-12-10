package org.demo.documentation.fields.dictionary.dictionarydictionary.restapi;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyEntity380ExternalResponse  implements Serializable {

    private String type;
    private String key;
    private String value;
    private Integer displayOrder;

}