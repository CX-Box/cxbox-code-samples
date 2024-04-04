package org.demo.documentation.percent.additionalproperties.digits;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity310 extends BaseEntity {

	@Column
	private Double customField;

}