package org.demo.documentation.inlinepicklist.ro;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.inlinepicklist.ro.picklist.MyEntity138;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity139 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity138 customFieldEntity;

}