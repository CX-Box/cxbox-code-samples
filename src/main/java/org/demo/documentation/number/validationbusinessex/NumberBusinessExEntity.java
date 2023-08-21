package org.demo.documentation.number.validationbusinessex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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