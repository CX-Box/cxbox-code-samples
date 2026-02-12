package org.demo.documentation.feature.drilldown.advancedfulltextsearchfilter;

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
public class MyEntity3615 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customField2;
	@Column
	private String fullName;
	@Column
	private String address;
}