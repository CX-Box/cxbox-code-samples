package org.demo.documentation.widgets.headerwidget.showcondition.bycurrententity;

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
public class MyEntity5026 extends BaseEntity {

	@Column
	private Long customField = 0L;
}
