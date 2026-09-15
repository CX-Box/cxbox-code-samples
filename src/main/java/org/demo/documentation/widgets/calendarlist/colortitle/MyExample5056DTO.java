package org.demo.documentation.widgets.calendarlist.colortitle;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5056DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "startDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime startDateTime;

	@SearchParameter(name = "endDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime endDateTime;

	private String customFieldColor;

	// --8<-- [start:colorDTO]
	public MyExample5056DTO(MyEntity5056 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.startDateTime = entity.getStartDateTime();
		this.endDateTime = entity.getEndDateTime();
		this.customFieldColor = "#eda6a6";
		// --8<-- [end:colorDTO]
	}

}
