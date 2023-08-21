package org.demo.documentation.inlinepicklist.validationruntimeex.picklist;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity155 extends BaseEntity {

	@Column
	private String customField;

}