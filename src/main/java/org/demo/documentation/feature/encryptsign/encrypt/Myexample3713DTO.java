package org.demo.documentation.feature.encryptsign.encrypt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.encryptsign.encrypt.enums.StatusEncryptEnum;
import org.demo.documentation.feature.encryptsign.encryptsign.enums.StatusEncryptSignEnum;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3713DTO extends DataResponseDTO {

	public static final String NAME_FILE_OVERRIDE_ENCRYPT = "MyEncrypt";

	@SearchParameter(name = "file", provider = StringValueProvider.class)
	private String file;

	private String fileId;

	@SearchParameter(name = "fileEncrypt", provider = StringValueProvider.class)
	private String fileEncrypt;

	@SearchParameter(name = "fileEncrypt", provider = StringValueProvider.class)
	private String fileEncryptRO;

	private String fileEncryptId;

	@SearchParameter(name = "status", provider = EnumValueProvider.class)
	private StatusEncryptEnum status;

	private String color;

	public Myexample3713DTO(Myexample3713 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.file = entity.getFile();
		this.fileId = entity.getFileId();
		this.fileEncrypt = entity.getFileEncrypt();
		this.fileEncryptRO = entity.getFileEncrypt();
		this.fileEncryptId = entity.getFileEncryptId();
		this.status = entity.getStatus();
		this.color = Optional.ofNullable(entity.getStatus()).map(StatusEncryptSignEnum.colors::get).orElse(null);
	}

}
