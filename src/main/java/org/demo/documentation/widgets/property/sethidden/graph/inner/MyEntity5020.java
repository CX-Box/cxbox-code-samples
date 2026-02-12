package org.demo.documentation.widgets.property.sethidden.graph.inner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.sethidden.graph.inner.enums.ProductNameEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5020 extends BaseEntity {
	@Column
	private String customField;

	@Column
	private String clientName;

	@Enumerated(value = EnumType.STRING)
	@Column
	private ProductNameEnum productName;

	@Column
	private Long sum;
}
