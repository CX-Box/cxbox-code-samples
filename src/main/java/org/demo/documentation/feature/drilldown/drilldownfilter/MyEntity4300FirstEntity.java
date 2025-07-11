package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class MyEntity4300FirstEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "MY_ENTITY4300_SECOND_ENTITY_ID")
	private MyEntity4300SecondEntity secondEntity;

}
