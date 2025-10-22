package org.demo.documentation.widgets.property.pagination.nextandprevioussmart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.widgets.property.pagination.nextandprevioussmart.enums.CustomFieldDictionaryEnum;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3861OutServiceDTO implements Serializable {

    private String id;
    private String customField;
    private LocalDateTime customFieldDateTime;

    private CustomFieldDictionaryEnum customFieldDictionary;
}