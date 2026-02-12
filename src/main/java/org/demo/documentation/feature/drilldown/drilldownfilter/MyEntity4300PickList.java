package org.demo.documentation.feature.drilldown.drilldownfilter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class MyEntity4300PickList extends BaseEntity {

	@Column
	private String value;

}
