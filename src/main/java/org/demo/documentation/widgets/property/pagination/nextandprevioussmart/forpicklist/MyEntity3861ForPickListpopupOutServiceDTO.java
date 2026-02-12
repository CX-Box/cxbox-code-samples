package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forpicklist;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3861ForPickListpopupOutServiceDTO implements Serializable {

	@Id
	private String id;
	private String customField;
	private LocalDateTime customFieldDateTime;

}