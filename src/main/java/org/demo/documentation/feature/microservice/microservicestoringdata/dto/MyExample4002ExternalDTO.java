package org.demo.documentation.feature.microservice.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity4002External;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4002ExternalDTO implements Serializable {

	private String id;
	private String customField;

	public MyExample4002ExternalDTO(MyEntity4002External entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}
