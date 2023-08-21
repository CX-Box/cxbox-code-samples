package org.demo.documentation.number.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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