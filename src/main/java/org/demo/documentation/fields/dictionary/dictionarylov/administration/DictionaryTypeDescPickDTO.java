package org.demo.documentation.fields.dictionary.dictionarylov.administration;
import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.dictionary.entity.DictionaryTypeDesc;

@Getter
@Setter
@NoArgsConstructor
public class DictionaryTypeDescPickDTO extends DataResponseDTO {

	private String type;

	public DictionaryTypeDescPickDTO(DictionaryTypeDesc entity) {
		this.id = entity.getId().toString();
		this.type = entity.getType();
	}

}
