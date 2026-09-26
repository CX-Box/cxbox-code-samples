package org.demo.documentation.widgets.column2d.showcondition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyEntity4276 extends BaseEntity {

	@Column
	private Long customField;

}
