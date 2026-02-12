package org.demo.documentation.widgets.statsblock.base.customfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4200DTO extends DataResponseDTO {

	private String customFieldTitle;
	private String customFieldValue;
	private String customFieldIcon;
	private String customFieldDescription;
	private String customField;
	private String customFieldNum;
}