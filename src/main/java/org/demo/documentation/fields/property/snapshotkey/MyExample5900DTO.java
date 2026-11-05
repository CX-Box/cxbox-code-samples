package org.demo.documentation.fields.property.snapshotkey;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.fields.property.snapshotkey.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5900DTO extends DataResponseDTO {

	private String scenario;

	// --8<-- [start:fields]
	private String inputField;

	private String inputFieldSnapshot;

	private String textField;

	private String textFieldSnapshot;

	private String hintField;

	private String hintFieldSnapshot;

	private Long numberField;

	private Long numberFieldSnapshot;

	private Double moneyField;

	private Double moneyFieldSnapshot;

	private Long percentField;

	private Long percentFieldSnapshot;

	private LocalDateTime dateField;

	private LocalDateTime dateFieldSnapshot;

	private LocalDateTime dateTimeField;

	private LocalDateTime dateTimeFieldSnapshot;

	private LocalDateTime dateTimeWithSecondsField;

	private LocalDateTime dateTimeWithSecondsFieldSnapshot;

	private Boolean checkboxField;

	private Boolean checkboxFieldSnapshot;

	private Long pickListFieldId;

	private String pickListField;

	private String pickListFieldSnapshot;

	private Long inlinePickListFieldId;

	private String inlinePickListField;

	private String inlinePickListFieldSnapshot;

	private CustomFieldEnum dictionaryField;

	private CustomFieldEnum dictionaryFieldSnapshot;

	private CustomFieldEnum radioField;

	private CustomFieldEnum radioFieldSnapshot;
	// --8<-- [end:fields]

	public MyExample5900DTO(MyEntity5900 entity) {
		this.id = entity.getId().toString();
		this.scenario = entity.getScenario();
		this.inputField = entity.getInputField();
		this.inputFieldSnapshot = entity.getInputFieldSnapshot();
		this.textField = entity.getTextField();
		this.textFieldSnapshot = entity.getTextFieldSnapshot();
		this.hintField = entity.getHintField();
		this.hintFieldSnapshot = entity.getHintFieldSnapshot();
		this.numberField = entity.getNumberField();
		this.numberFieldSnapshot = entity.getNumberFieldSnapshot();
		this.moneyField = entity.getMoneyField();
		this.moneyFieldSnapshot = entity.getMoneyFieldSnapshot();
		this.percentField = entity.getPercentField();
		this.percentFieldSnapshot = entity.getPercentFieldSnapshot();
		this.dateField = entity.getDateField();
		this.dateFieldSnapshot = entity.getDateFieldSnapshot();
		this.dateTimeField = entity.getDateTimeField();
		this.dateTimeFieldSnapshot = entity.getDateTimeFieldSnapshot();
		this.dateTimeWithSecondsField = entity.getDateTimeWithSecondsField();
		this.dateTimeWithSecondsFieldSnapshot = entity.getDateTimeWithSecondsFieldSnapshot();
		this.checkboxField = entity.getCheckboxField();
		this.checkboxFieldSnapshot = entity.getCheckboxFieldSnapshot();
		this.pickListFieldId = Optional.ofNullable(entity.getPickListEntity()).map(MyEntity5900Pick::getId).orElse(null);
		this.pickListField = Optional.ofNullable(entity.getPickListEntity())
				.map(MyEntity5900Pick::getCustomField)
				.orElse(null);
		this.pickListFieldSnapshot = entity.getPickListFieldSnapshot();
		this.inlinePickListFieldId = Optional.ofNullable(entity.getInlinePickListEntity())
				.map(MyEntity5900Pick::getId)
				.orElse(null);
		this.inlinePickListField = Optional.ofNullable(entity.getInlinePickListEntity())
				.map(MyEntity5900Pick::getCustomField)
				.orElse(null);
		this.inlinePickListFieldSnapshot = entity.getInlinePickListFieldSnapshot();
		this.dictionaryField = entity.getDictionaryField();
		this.dictionaryFieldSnapshot = entity.getDictionaryFieldSnapshot();
		this.radioField = entity.getRadioField();
		this.radioFieldSnapshot = entity.getRadioFieldSnapshot();
	}

}
