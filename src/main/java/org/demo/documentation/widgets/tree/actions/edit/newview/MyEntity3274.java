package org.demo.documentation.widgets.tree.actions.edit.newview;

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
public class MyEntity3274 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldText;

	@Column
	private String parentId;

	@Column
	private Double customFieldMoney;
}