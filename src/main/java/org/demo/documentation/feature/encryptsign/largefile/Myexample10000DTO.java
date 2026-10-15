package org.demo.documentation.feature.encryptsign.largefile;

import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.model.core.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
public class Myexample10000DTO extends DataResponseDTO {

	@SearchParameter(name = "description")
	private String description;

	@SearchParameter(name = "file")
	private String file;

	private String fileId;

	private String fileSign;

	@SearchParameter(name = "fileSign")
	private String fileSignRO;

	private String fileSignId;

	private String fileEncrypt;

	@SearchParameter(name = "fileEncrypt")
	private String fileEncryptRO;

	private String fileEncryptId;

	private String lastOperation;

	public Myexample10000DTO(Myexample10000 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.description = entity.getDescription();
		this.file = entity.getFile();
		this.fileId = entity.getFileId();
		this.fileSign = entity.getFileSign();
		this.fileSignRO = entity.getFileSign();
		this.fileSignId = entity.getFileSignId();
		this.fileEncrypt = entity.getFileEncrypt();
		this.fileEncryptRO = entity.getFileEncrypt();
		this.fileEncryptId = entity.getFileEncryptId();
		this.lastOperation = entity.getLastOperation();
	}

}
