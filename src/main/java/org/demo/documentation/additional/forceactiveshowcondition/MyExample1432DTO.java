package org.demo.documentation.additional.forceactiveshowcondition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.additional.forceactiveshowcondition.enums.AccountableCrsEnum;
import org.demo.documentation.additional.forceactiveshowcondition.enums.CrsStatusEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample1432DTO extends DataResponseDTO {

	private CrsStatusEnum crsStatus;

	private AccountableCrsEnum accountableCrs;

	/**
	 * Technical field for the child widgets showCondition, it is recalculated by forceActive of accountableCrs
	 */
	private Boolean accountableCrsShowCondition;

	public MyExample1432DTO(MyEntity1432 entity) {
		this.id = entity.getId().toString();
		this.crsStatus = entity.getCrsStatus();
		this.accountableCrs = AccountableCrsEnum.byBoolean(entity.getAccountableCrs());
		this.accountableCrsShowCondition = Boolean.TRUE.equals(entity.getAccountableCrs());
	}

}
