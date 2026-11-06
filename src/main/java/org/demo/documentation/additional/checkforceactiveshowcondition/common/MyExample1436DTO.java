package org.demo.documentation.additional.checkforceactiveshowcondition.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.enums.CrsStatusEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample1436DTO extends DataResponseDTO {

	private String country;

	private String tin;

	private CrsStatusEnum crsStatus;

	private Boolean isLeaf;

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private String parentId;

	public MyExample1436DTO(MyEntity1436 entity) {
		this.id = entity.getId().toString();
		this.country = entity.getCountry();
		this.tin = entity.getTin();
		this.crsStatus = entity.getCrsStatus();
		this.parentId = entity.getParentId() == null ? null : entity.getParentId().toString();
		this.isLeaf = entity.getChildren().isEmpty();
	}

}
