package org.demo.documentation.feature.microservice.nextandprevioussmart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3861OutServiceDTO implements Serializable {

    private String id;
    private String customField;
    private LocalDateTime customFieldDateTime;

}