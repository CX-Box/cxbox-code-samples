package org.demo.documentation.widgets.calendarlist.actions.edit.newview;

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
public class MyExample5065DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "startDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime startDateTime;

	@SearchParameter(name = "endDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime endDateTime;

	public MyExample5065DTO(MyEntity5065 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.startDateTime = entity.getStartDateTime();
		this.endDateTime = entity.getEndDateTime();
	}

}
