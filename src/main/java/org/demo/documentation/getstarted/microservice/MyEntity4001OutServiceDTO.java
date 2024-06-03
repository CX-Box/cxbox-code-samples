package org.demo.documentation.getstarted.microservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4001OutServiceDTO implements Serializable {

    private String id;
    private String customField;
}