package org.demo.documentation.number.drilldown;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberDrillDown
@Entity
@Table(name = "NumberDrillDownEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberDrillDownEntity extends BaseEntity {


	@Column
	private Long customField;

}