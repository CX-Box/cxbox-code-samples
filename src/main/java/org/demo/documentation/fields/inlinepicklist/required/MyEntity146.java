package org.demo.documentation.fields.inlinepicklist.required;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.inlinepicklist.required.picklist.MyEntity147;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity146 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity147 customFieldEntity;

}