package org.demo.documentation.feature.drilldown.drilldownfilter;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class MyEntity4300WithDriildownKey extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "MY_ENTITY4300_FIRST_ENTITY_ID")
	private MyEntity4300FirstEntity firstEntity;

}
