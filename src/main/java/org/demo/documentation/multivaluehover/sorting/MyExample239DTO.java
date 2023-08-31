package org.demo.documentation.multivaluehover.sorting;

import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
@Getter
@Setter
@NoArgsConstructor
public class MyExample239DTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
	private MultivalueField customField;

	private String customFieldCalc;

	public MyExample239DTO(MyEntity239 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity240::getCustomField
		));
		this.customFieldCalc = entity.getCustomFieldList().stream()
				.map(MyEntity240::getCustomField)
				.collect(Collectors.joining(", "));
	}

}