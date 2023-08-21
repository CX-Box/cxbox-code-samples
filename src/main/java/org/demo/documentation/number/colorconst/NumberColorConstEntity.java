package org.demo.documentation.number.colorconst;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberColorConst
@Entity
@Table(name = "NumberColorConstEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberColorConstEntity extends BaseEntity {


	@Column
	private Long customField;

}