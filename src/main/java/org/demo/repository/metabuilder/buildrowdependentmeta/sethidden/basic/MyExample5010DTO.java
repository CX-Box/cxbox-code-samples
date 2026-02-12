package org.demo.repository.metabuilder.buildrowdependentmeta.sethidden.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.repository.metabuilder.buildrowdependentmeta.sethidden.basic.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5010DTO extends DataResponseDTO {

	public static final String TEXT = "setHidden - if CustomField != High customFieldHidden show";

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	@SearchParameter(name = "customFieldHidden", provider = StringValueProvider.class)
	private String customFieldHidden;

	public MyExample5010DTO(MyEntity5010 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldHidden = entity.getCustomFieldHidden();
	}
}
