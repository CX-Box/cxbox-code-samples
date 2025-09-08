package org.demo.documentation.fields.suggestion.filtration;

import lombok.experimental.SuperBuilder;
import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class SdfsdfDTO extends DataResponseDTO {


	public SdfsdfDTO(SdfsdfDTO entity) {
		this.id = entity.getId();
	}

}
