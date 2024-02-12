package org.demo.documentation.other.test;

import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

import static org.demo.documentation.main.TextError.ONLY_LETTER;


@Getter
@Setter
@NoArgsConstructor
public class MyExample420DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	@Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
	private String customField;

	@SearchParameter(name = "customField2")
	@Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
	private String customField2;

	@Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
	private String customField3;

	@Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
	@SearchParameter(name = "customFieldForceActive")
	private String customFieldForceActive;

	@Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
	@SearchParameter(name = "customFieldForceActive3")
	private String customFieldForceActive3;

	@Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
	@SearchParameter(name = "customFieldForceActive2")
	private String customFieldForceActive2;


	public MyExample420DTO(MyEntity420 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customField2 = entity.getCustomField2();
		this.customField3 = entity.getCustomField3();

		this.customFieldForceActive = entity.getCustomFieldForceActive();
		this.customFieldForceActive3 = entity.getCustomFieldForceActive3();
		this.customFieldForceActive2 = entity.getCustomFieldForceActive2();
	}

}