package org.demo.documentation.widgets.statsblock.showcondition.byparententity.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4233DTO extends DataResponseDTO {

	private String title;

	private Long value;

	public MyExample4233DTO(MyEntity4233 entity) {
		this.id = entity.getId().toString();
		this.title = entity.getTitle();
		this.value = entity.getValue();
	}

}
