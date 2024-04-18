package org.demo.documentation.microservice.createmicroservices;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3810OutServiceDTO implements Serializable {

    private String id;
    private String customField;

}