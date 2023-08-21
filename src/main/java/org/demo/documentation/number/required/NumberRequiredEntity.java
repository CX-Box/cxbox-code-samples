package org.demo.documentation.number.required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberRequired
@Entity
@Table(name = "NumberRequiredEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberRequiredEntity extends BaseEntity {


	@Column
	private Long customField;

}