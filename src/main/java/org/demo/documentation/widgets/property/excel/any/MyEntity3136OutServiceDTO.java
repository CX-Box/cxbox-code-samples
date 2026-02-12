package org.demo.documentation.widgets.property.excel.any;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3136OutServiceDTO implements Serializable {

	private String id;
	private String customField;
	private LocalDateTime customFieldDateTime;
}