package org.demo.documentation.feature.encryptsign.signencrypt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.encryptsign.signencrypt.enums.StatusSignEncryptEnum;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3714DTO extends DataResponseDTO {

	public static final String NAME_FILE_OVERRIDE_SIGN = "MySign";

	public static final String NAME_FILE_OVERRIDE_ENCRYPT = "MyEncrypt";

	@SearchParameter(name = "file", provider = StringValueProvider.class)
	private String file;

	private String fileId;

	@SearchParameter(name = "fileEncryptAndSign", provider = StringValueProvider.class)
	private String fileEncryptAndSign;

	private String fileEncryptAndSignId;

	@SearchParameter(name = "fileEncrypt", provider = StringValueProvider.class)
	private String fileEncrypt;

	@SearchParameter(name = "fileEncrypt", provider = StringValueProvider.class)
	private String fileEncryptRO;

	private String fileEncryptId;

	@SearchParameter(name = "fileSign", provider = StringValueProvider.class)
	private String fileSign;

	@SearchParameter(name = "fileSign", provider = StringValueProvider.class)
	private String fileSignRO;

	private String fileSignId;

	private String color;

	@SearchParameter(name = "status", provider = EnumValueProvider.class)
	private StatusSignEncryptEnum status;

	public Myexample3714DTO(Myexample3714 entity) {
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
		this.color = Optional.ofNullable(entity.getStatus()).map(StatusSignEncryptEnum.colors::get).orElse(null);
		this.status = entity.getStatus();
	}

}
