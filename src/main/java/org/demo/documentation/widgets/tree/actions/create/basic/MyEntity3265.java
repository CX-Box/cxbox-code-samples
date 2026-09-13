package org.demo.documentation.widgets.tree.actions.create.basic;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.actions.create.basic.enums.CustomFieldDictionaryEnum;

import java.util.ArrayList;
import java.util.List;


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
	private Long parentId;

	@Column
	private Double customFieldMoney;

	@OneToMany(
			mappedBy = "parentId",
			fetch = FetchType.LAZY
	)
	private List<MyEntity3265> children = new ArrayList<>();

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
}