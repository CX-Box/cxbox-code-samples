package org.demo.documentation.inlinepicklist.drilldown;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.inlinepicklist.drilldown.picklist.MyEntity141;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity140 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity141 customFieldEntity;

}