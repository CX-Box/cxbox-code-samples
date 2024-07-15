package org.demo.documentation.fields.number.required;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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