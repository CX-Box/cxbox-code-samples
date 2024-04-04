package org.demo.documentation.picklist.validationconfirm;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity115 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity130 customFieldEntity;

}