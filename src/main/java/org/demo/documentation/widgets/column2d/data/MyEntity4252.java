package org.demo.documentation.widgets.column2d.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class MyEntity4252 extends BaseEntity {

	@Column
	private String clientName;

	@Enumerated(value = EnumType.STRING)
	@Column
	private MyEntity4252Product product;

	@Column
	private Long amount;
}
