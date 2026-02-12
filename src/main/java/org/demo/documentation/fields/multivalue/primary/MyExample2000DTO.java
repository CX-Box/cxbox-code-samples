package org.demo.documentation.fields.multivalue.primary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.conf.cxbox.extension.multivaluePrimary.MultivalueExt;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.demo.conf.cxbox.extension.multivaluePrimary.MultivalueExt.PRIMARY;


@Getter
@Setter
@NoArgsConstructor
public class MyExample2000DTO extends DataResponseDTO {


	@SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
	private MultivalueField customField;
	private String customFieldDisplayedKey;

	public MyExample2000DTO(MyEntity2000 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomFieldList().stream().collect(MultivalueExt.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity2001::getCustomField,
				Map.of(
						PRIMARY,
						field -> Objects.equals(field.getId(), entity.getPrimaryId()) ? Boolean.TRUE.toString()
								: null
				)
		));
		this.customFieldDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntity2001::getCustomField
		).collect(Collectors.joining(",")), 12);

	}
}