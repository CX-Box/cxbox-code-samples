package org.demo.documentation.fields.number.filtration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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