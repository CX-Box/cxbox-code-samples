package org.demo.documentation.fields.multivaluehover.placeholder;

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
public class MyEntityMulti235 extends BaseEntity {

	@Column
	private Double customField;

}