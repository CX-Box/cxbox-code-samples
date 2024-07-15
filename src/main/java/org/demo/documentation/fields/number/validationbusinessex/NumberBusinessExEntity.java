package org.demo.documentation.fields.number.validationbusinessex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberBusinessEx
@Entity
@Table(name = "NumberBusinessExEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberBusinessExEntity extends BaseEntity {


	@Column
	private Long customField;

}