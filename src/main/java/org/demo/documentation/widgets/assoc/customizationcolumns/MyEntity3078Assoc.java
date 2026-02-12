package org.demo.documentation.widgets.assoc.customizationcolumns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3078Assoc extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldTest;
	@Column
	private Long customFieldNumber;
	@Column
	private String customFieldText;
}