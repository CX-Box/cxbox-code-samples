package org.demo.documentation.additional.signunsavedrecord;

import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.model.core.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
public class MyExample1348DTO extends DataResponseDTO {

	private String file;

	private String fileId;

	private String fileSign;

	private String fileSignId;

	private String fileEncrypt;

	private String fileEncryptId;

	private String notes;

	private String status;

	public MyExample1348DTO(MyEntity1348 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.file = entity.getFile();
		this.fileId = entity.getFileId();
		this.fileSign = entity.getFileSign();
		this.fileSignId = entity.getFileSignId();
		this.fileEncrypt = entity.getFileEncrypt();
		this.fileEncryptId = entity.getFileEncryptId();
		this.notes = entity.getNotes();
		this.status = Boolean.TRUE.equals(entity.getSigned()) ? "Signed" : "Not Signed";
	}

}
