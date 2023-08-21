package org.demo.documentation.inlinepicklist.colorconst;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.inlinepicklist.colorconst.picklist.MyEntity137;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity136 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity137 customFieldEntity;

}