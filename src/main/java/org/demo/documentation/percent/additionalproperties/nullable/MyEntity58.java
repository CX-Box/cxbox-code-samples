package org.demo.documentation.percent.additionalproperties.nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity58 extends BaseEntity {

	@Column
	private Long customField;

}