package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import java.lang.String;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.fields.input.filtration.InputFiltration;

@Getter
@Setter
@NoArgsConstructor
public class InputFiltrationPickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
	private String name;

	private String shortName;
	private String inn;

	public InputFiltrationPickDTO(InputFiltration entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
		this.name = entity.getName();
		this.shortName = entity.getShortName();
		this.inn = entity.getInn();
    }

}
