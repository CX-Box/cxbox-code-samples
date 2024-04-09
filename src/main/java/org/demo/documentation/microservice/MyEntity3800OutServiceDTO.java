package org.demo.documentation.microservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3800OutServiceDTO implements Serializable {

    private String customField;

    private String id;
}