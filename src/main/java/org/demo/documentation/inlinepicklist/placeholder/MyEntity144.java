package org.demo.documentation.inlinepicklist.placeholder;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.inlinepicklist.placeholder.picklist.MyEntity145;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity144 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity145 customFieldEntity;

}