package org.demo.documentation.fields.suggestion.color.colorconst.forfield;


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
public class InputFiltrationPick0DTO extends DataResponseDTO {

    @SearchParameter(name = "inn", provider = StringValueProvider.class)
    private String inn;
	private String name;

	private String shortName;
    public InputFiltrationPick0DTO(InputFiltration entity) {
        this.id = entity.getId().toString();
        this.inn = entity.getInn();
		this.name = entity.getName();
		this.shortName = entity.getShortName();
    }

}
