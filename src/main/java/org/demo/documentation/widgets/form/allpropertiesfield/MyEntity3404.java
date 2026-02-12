package org.demo.documentation.widgets.form.allpropertiesfield;

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
public class MyEntity3404 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldPlaceholder;
	@Column
	private Long customFieldColor;
	@Column
	private Long customFieldColorConst;
	@Column
	private String customFieldColorDrilldown;
	@Column
	private String customFieldColorValidation;
	@Column
	private String customFieldColorSort;
	@Column
	private String customFieldRequired;
}