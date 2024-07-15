package org.demo.documentation.fields.money.validationdynamic;

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
public class MyEntity333 extends BaseEntity {

	@Column
	private Double customField;

	@Column
	private Double customFieldAdditional;

}