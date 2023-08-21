package org.demo.documentation.number.additionalproperties.digits;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//digitsNumber
@Entity
@Table(name = "DigitsNumberEntity")
@Getter
@Setter
@NoArgsConstructor
public class DigitsNumberEntity extends BaseEntity {


	@Column
	private Long customField;

}