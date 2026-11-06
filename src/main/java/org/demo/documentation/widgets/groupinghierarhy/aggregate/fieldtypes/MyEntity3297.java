package org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes.enums.CustomFieldDictionaryEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3297 extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;

	@Column
	private String customField;

	@Column
	private Long customFieldNumber;

	@Column
	private Double customFieldMoney;

	@Column
	private Long customFieldPercent;

	@Column
	private LocalDateTime customFieldDate;

	@Column
	private LocalDateTime customFieldDateTime;

	@Column
	private String customFieldInput;

	@Column
	private String customFieldColor;

}
