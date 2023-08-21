package org.demo.documentation.picklist.validationannotation;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity296 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity297 customFieldEntity;

}