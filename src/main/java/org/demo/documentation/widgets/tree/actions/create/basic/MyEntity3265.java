package org.demo.documentation.widgets.tree.actions.create.basic;

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
public class MyEntity3265 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldText;

	@Column
	private String parentId;

	@Column
	private Double customFieldMoney;
}