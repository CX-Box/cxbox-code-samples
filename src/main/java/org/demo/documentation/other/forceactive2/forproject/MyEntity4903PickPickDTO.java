package org.demo.documentation.other.forceactive2.forproject;
import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4903PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity4903PickPickDTO(MyEntity4903Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
