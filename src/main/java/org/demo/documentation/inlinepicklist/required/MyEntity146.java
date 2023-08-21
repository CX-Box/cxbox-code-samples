package org.demo.documentation.inlinepicklist.required;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.inlinepicklist.required.picklist.MyEntity147;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity146 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity147 customFieldEntity;

}