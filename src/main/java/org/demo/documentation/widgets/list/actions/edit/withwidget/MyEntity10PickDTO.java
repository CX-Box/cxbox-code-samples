package org.demo.documentation.widgets.list.actions.edit.withwidget;

import java.lang.Long;
import java.util.Optional;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.fields.percent.validationbusinessex.MyEntity10;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity10PickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = LongValueProvider.class)
    private Long customField;

	@SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
	private String customFieldText;

	@SearchParameter(name = "dfgdfgdEntity.customField", provider = StringValueProvider.class)
	private String dfgdfgd;

	@SearchParameter(name = "dfgdfgdEntity.id", provider = LongValueProvider.class)
	private Long dfgdfgdId;

	public MyEntity10PickDTO(MyEntity10 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
		this.dfgdfgdId = Optional.ofNullable(entity.getDfgdfgdEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.dfgdfgd = Optional.ofNullable(entity.getDfgdfgdEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}

}
