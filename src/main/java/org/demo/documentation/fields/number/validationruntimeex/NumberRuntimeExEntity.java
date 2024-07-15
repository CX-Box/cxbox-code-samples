package org.demo.documentation.fields.number.validationruntimeex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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