package org.demo.documentation.other.anysource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3420OutServiceDTO implements Serializable {

    private String id;
    private String customField;
    private String customFieldNew;
    private LocalDateTime customFieldDateTime;
    private Double customFieldDouble;
}