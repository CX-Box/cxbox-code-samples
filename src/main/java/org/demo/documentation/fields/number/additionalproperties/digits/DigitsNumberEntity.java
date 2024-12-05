package org.demo.documentation.fields.number.additionalproperties.digits;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
	private Double customField;

}