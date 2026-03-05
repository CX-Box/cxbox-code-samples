package org.demo.documentation.other.drilldown.option.any;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3424DTO extends DataResponseDTO {
	private String customField;

	private String fileName;

	private String fileNameId;

	private MultivalueField files;

	public MyExample3424DTO(MyEntity3424OutServiceDTO entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.fileName = entity.getFileName();
		this.fileNameId = entity.getFileNameId();
		this.files = entity.getFiles();
	}
}