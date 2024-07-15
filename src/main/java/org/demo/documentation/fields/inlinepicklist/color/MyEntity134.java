package org.demo.documentation.fields.inlinepicklist.color;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.inlinepicklist.color.picklist.MyEntity135;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity134 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity135 customFieldEntity;

}