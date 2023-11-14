package org.demo.documentation.widgets.form.fieldslayoute;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3004DTO extends DataResponseDTO {

	public static final String SINGLE_COLUMN_LAYOUT_TEXT = "Shows each field on new row. Each field can have width from 1 to 24";
	public static final String MULTI_COLUMN_LAYOUT_TEXT = "Shows fields in grid.Grid can contain any number of rows. Each row can contain any number of fields, until sum of fields widths in row is less than 24. Each field can have width from 1 to 24.";
	public static final String ONLY_BUTTONS_TEXT = "only title and actions are shown. Usually used when standard buttons position needs to be changed (for example we want to show buttons under widget). One can hide buttons on widget with data. Create separate widget only with buttons and place it anywhere on view";


	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;
	@SearchParameter(name = "customField2", provider = StringValueProvider.class)
	private String customField2;
	@SearchParameter(name = "customField3", provider = StringValueProvider.class)
	private String customField3;
	@SearchParameter(name = "customField4", provider = StringValueProvider.class)
	private String customField4;
	@SearchParameter(name = "customField5", provider = StringValueProvider.class)
	private String customField5;
	private String customField6;
	private String customField7;
	private String customField8;

	public MyExample3004DTO(MyEntity3004 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();

		this.customField2 = entity.getCustomField2();
		this.customField3 = entity.getCustomField3();
		this.customField4 = entity.getCustomField4();
		this.customField5 = entity.getCustomField5();
		this.customField6 = SINGLE_COLUMN_LAYOUT_TEXT;
		this.customField7 = MULTI_COLUMN_LAYOUT_TEXT;
		this.customField8 = ONLY_BUTTONS_TEXT;
	}

}