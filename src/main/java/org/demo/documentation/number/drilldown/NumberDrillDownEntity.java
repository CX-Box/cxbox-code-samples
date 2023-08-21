package org.demo.documentation.number.drilldown;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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