package org.demo.documentation.fields.dictionary.dictionarylov.anysorce.dictionaryanysource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity380OutServiceDTO implements Serializable {

    private String type;
    private String key;
    private String value;
    private Integer displayOrder;

}