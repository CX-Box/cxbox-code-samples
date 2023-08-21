package org.demo.documentation.inlinepicklist.sorting;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.inlinepicklist.sorting.picklist.MyEntity149;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity148 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity149 customFieldEntity;

}