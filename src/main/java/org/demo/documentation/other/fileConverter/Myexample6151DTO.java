package org.demo.documentation.other.fileConverter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Myexample6151DTO extends DataResponseDTO {


	@SearchParameter(name = "fileName")
	private String fileName;

	private String fileNameId;

	@SearchParameter(name = "fileNameNAF")
	private String fileNameNAF;

	private String fileNameNAFId;


	public Myexample6151DTO(Myexample6151 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.fileName = entity.getFileName();
		this.fileNameId = entity.getFileNameId();
	}

}
