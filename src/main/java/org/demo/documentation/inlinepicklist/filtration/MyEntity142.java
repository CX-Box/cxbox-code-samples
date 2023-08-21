package org.demo.documentation.inlinepicklist.filtration;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.inlinepicklist.filtration.picklist.MyEntity143;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity142 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity143 customFieldEntity;

}