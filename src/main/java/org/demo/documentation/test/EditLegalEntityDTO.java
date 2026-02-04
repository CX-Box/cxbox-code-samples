package org.demo.documentation.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class EditLegalEntityDTO extends DataResponseDTO {


	@SearchParameter(name = "sdsad", provider = StringValueProvider.class)
	private String sdsad;

	public EditLegalEntityDTO(EditLegalEntity entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.sdsad = entity.getSdsad();
	}

}
