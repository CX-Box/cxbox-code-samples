package org.demo.documentation.feature.microservice.existingmicroservices;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3800OutServiceDTO implements Serializable {

	private String id;
	private String customField;
	private String customField2;
}