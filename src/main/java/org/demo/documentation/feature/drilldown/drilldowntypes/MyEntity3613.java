package org.demo.documentation.feature.drilldown.drilldowntypes;

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
public class MyEntity3613 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldExternal;
	@Column
	private String customFieldExternalNew;
	@Column
	private String customFieldRelative;
	@Column
	private String customFieldRelativeNew;
}