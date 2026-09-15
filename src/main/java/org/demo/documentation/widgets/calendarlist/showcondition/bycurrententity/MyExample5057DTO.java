package org.demo.documentation.widgets.calendarlist.showcondition.bycurrententity;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5057DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "startDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime startDateTime;

	@SearchParameter(name = "endDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime endDateTime;

	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;

	private String customFieldShowCond;

	public MyExample5057DTO(MyEntity5057 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.startDateTime = entity.getStartDateTime();
		this.endDateTime = entity.getEndDateTime();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldShowCond = entity.getCustomFieldNumber() > 5 ? "true" : "false";
	}

}
