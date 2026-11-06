package org.demo.documentation.widgets.dualaxes2d.data;

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
 * All DualAxes2D samples aggregate this table: the sum of the sales and the number of the sales.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyEntity4280 extends BaseEntity {

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
