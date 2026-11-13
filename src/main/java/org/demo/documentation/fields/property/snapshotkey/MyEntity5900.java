package org.demo.documentation.fields.property.snapshotkey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.property.snapshotkey.enums.CustomFieldEnum;

/**
 * Each field has a pair: the current value and the snapshot (previous) value.
 * The snapshot value is shown via "snapshotKey" in .widget.json
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5900 extends BaseEntity {

	@Column
	private String scenario;

	@Column
	private String inputField;

	@Column
	private String inputFieldSnapshot;

	@Column(length = 2000)
	private String textField;

	@Column(length = 2000)
	private String textFieldSnapshot;

	@Column
	private String hintField;

	@Column
	private String hintFieldSnapshot;

	@Column
	private Long numberField;

	@Column
	private Long numberFieldSnapshot;

	@Column
	private Double moneyField;

	@Column
	private Double moneyFieldSnapshot;

	@Column
	private Long percentField;

	@Column
	private Long percentFieldSnapshot;

	@Column
	private LocalDateTime dateField;

	@Column
	private LocalDateTime dateFieldSnapshot;

	@Column
	private LocalDateTime dateTimeField;

	@Column
	private LocalDateTime dateTimeFieldSnapshot;

	@Column
	private LocalDateTime dateTimeWithSecondsField;

	@Column
	private LocalDateTime dateTimeWithSecondsFieldSnapshot;

	@Column
	private Boolean checkboxField;

	@Column
	private Boolean checkboxFieldSnapshot;

	@JoinColumn(name = "PICK_LIST_ENTITY_ID")
	@ManyToOne
	private MyEntity5900Pick pickListEntity;

	@Column
	private String pickListFieldSnapshot;

	@JoinColumn(name = "INLINE_PICK_LIST_ENTITY_ID")
	@ManyToOne
	private MyEntity5900Pick inlinePickListEntity;

	@Column
	private String inlinePickListFieldSnapshot;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldEnum dictionaryField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldEnum dictionaryFieldSnapshot;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldEnum radioField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldEnum radioFieldSnapshot;

	@Column
	private String fileUploadField;

	@Column
	private String fileUploadFieldId;

	@Column
	private String fileUploadFieldSnapshot;

	@Column
	private String fileUploadFieldSnapshotId;

}
