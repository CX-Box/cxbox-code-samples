package org.demo.documentation.feature.encryptsign.sign;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.encryptsign.sign.enums.StatusSignEnum;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Myexample3711DTO extends DataResponseDTO {

	public static final String NAME_FILE_OVERRIDE_SIGN = "MySign";

	@SearchParameter(name = "file")
	private String file;

	private String fileId;

	@SearchParameter(name = "fileSign")
	private String fileSign;

	private String fileSignId;

	@SearchParameter(name = "fileSign")
	private String fileSignRO;

	private String color;

	@SearchParameter(name = "status", provider = EnumValueProvider.class)
	private StatusSignEnum status;

	public Myexample3711DTO(Myexample3711 entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.file = entity.getFile();
		this.fileId = entity.getFileId();
		this.fileSign = entity.getFileSign();
		this.fileSignId = entity.getFileSignId();
		this.fileSignRO = entity.getFileSign();
		this.color = Optional.ofNullable(entity.getStatus()).map(StatusSignEnum.colors::get).orElse(null);
		this.status = entity.getStatus();
	}

}
