package org.demo.documentation.widgets.property.collapse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.collapse.enums.CustomFieldDictionaryEnum;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3022 extends BaseEntity {
	@Column
	private String customField;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;

	@Column
	private String parentId;

	@OneToMany(
			mappedBy = "parentId",
			fetch = FetchType.LAZY
	)
	private List<MyEntity3022> children = new ArrayList<>();
}