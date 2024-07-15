package org.demo.documentation.fields.inlinepicklist.filtration;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.inlinepicklist.filtration.picklist.MyEntity143;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity142 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity143 customFieldEntity;

}