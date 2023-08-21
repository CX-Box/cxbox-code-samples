package org.demo.documentation.number.validationruntimeex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberRuntimeEx
@Entity
@Table(name = "NumberRuntimeExEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberRuntimeExEntity extends BaseEntity {


	@Column
	private Long customField;

}