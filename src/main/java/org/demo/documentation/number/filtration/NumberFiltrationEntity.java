package org.demo.documentation.number.filtration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//numberFiltration
@Entity
@Table(name = "NumberFiltrationEntity")
@Getter
@Setter
@NoArgsConstructor
public class NumberFiltrationEntity extends BaseEntity {


	@Column
	private Long customField;

}