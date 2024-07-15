package org.demo.documentation.fields.inlinepicklist.placeholder.picklist;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity145 extends BaseEntity {

	@Column
	private String customField;

}