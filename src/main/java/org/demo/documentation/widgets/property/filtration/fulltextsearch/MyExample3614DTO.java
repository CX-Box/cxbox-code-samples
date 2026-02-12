package org.demo.documentation.widgets.property.filtration.fulltextsearch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3614DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "fullName")
	private String fullName;
	@SearchParameter(name = "address")
	private String address;
	@SearchParameter(name = "customFieldMultivalueDisplayedKeyList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalueDisplayedKey;
	private String customFieldMultivalueDisplayedKeyDisplayedKey;
	@SearchParameter(name = "customFieldPicklistEntity.customField")
	private String customFieldPicklist;
	@SearchParameter(name = "customFieldPicklistEntity.id", provider = LongValueProvider.class)
	private Long customFieldPicklistId;

	public MyExample3614DTO(MyEntity3614 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.fullName = entity.getFullName();
		this.address = entity.getAddress();
		this.customFieldMultivalueDisplayedKey = entity.getCustomFieldMultivalueDisplayedKeyList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldMultivalueDisplayedKeyDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueDisplayedKeyList().stream().map(MyEntity3625::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
		this.customFieldPicklistId = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPicklist = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}
}