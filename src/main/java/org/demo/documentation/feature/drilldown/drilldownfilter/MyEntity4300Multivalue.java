package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Entity;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class MyEntity4300Multivalue extends BaseEntity {

	private String value;

}
