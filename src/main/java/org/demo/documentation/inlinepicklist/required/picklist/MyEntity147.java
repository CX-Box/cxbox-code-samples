package org.demo.documentation.inlinepicklist.required.picklist;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
// 147
// 
//  ",

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity147 extends BaseEntity {

	@Column
	private String customField;

}