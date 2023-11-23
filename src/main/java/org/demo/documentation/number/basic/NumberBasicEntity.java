package org.demo.documentation.number.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberBasic
@Entity
@Table(name = "NumberBasicEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberBasicEntity extends BaseEntity {


	@Column
	private Long customField;

}