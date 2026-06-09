package org.demo.documentation.feature.encryptsign.encryptsign;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.encryptsign.encryptsign.enums.StatusEncryptSignEnum;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3712DTO extends DataResponseDTO {

	public static final String NAME_FILE_OVERRIDE_SIGN = "MySign";

	public static final String NAME_FILE_OVERRIDE_ENCRYPT = "MyEncrypt";

	@SearchParameter(name = "file")
	private String file;

	private String fileId;

	@SearchParameter(name = "fileEncryptAndSign")
	private String fileEncryptAndSign;

	private String fileEncryptAndSignId;

	@SearchParameter(name = "fileEncrypt")
	private String fileEncrypt;

	@SearchParameter(name = "fileEncrypt")
	private String fileEncryptRO;

	private String fileEncryptId;

	@SearchParameter(name = "fileSign")
	private String fileSign;

	@SearchParameter(name = "fileSign")
	private String fileSignRO;

	private String fileSignId;

	@SearchParameter(name = "status", provider = EnumValueProvider.class)
	private StatusEncryptSignEnum status;

	private String color;

	public Myexample3712DTO(Myexample3712 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.file = entity.getFile();
		this.fileId = entity.getFileId();
		this.fileEncryptAndSign = entity.getFileEncryptAndSign();
		this.fileEncryptAndSignId = entity.getFileEncryptAndSignId();
		this.fileEncrypt = entity.getFileEncrypt();
		this.fileEncryptRO = entity.getFileEncrypt();
		this.fileEncryptId = entity.getFileEncryptId();
		this.fileSign = entity.getFileSign();
		this.fileSignRO = entity.getFileSign();
		this.fileSignId = entity.getFileSignId();
		this.status = entity.getStatus();
		this.color = Optional.ofNullable(entity.getStatus()).map(StatusEncryptSignEnum.colors::get).orElse(null);
	}

}
