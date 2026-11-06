package org.demo.documentation.feature.drilldown.drilldowntooltip;

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
public class MyEntity3626 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customFieldDrillDown;

	@Column
	private String customFieldFilterDrillDown;

	@Column
	private String customFieldExternalDrillDown;

}
