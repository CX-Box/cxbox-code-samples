package org.demo.documentation.picklist.color;

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
public class MyEntity119 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity121 customFieldEntity;

}