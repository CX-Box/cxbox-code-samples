package org.demo.documentation.widgets.line2d.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.model.core.entity.BaseEntity;

/**
 * One sale: the month it was made in, the client, the product and the amount.
 * All Line2D samples aggregate this table.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyEntity4240 extends BaseEntity {

	@Column
	private Long month;

	@Column
	private String clientName;

	@Enumerated(value = EnumType.STRING)
	@Column
	private ProductEnum productName;

	@Column
	private Long sum;

}
