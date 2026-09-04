package org.demo.documentation.widgets.tree.actions.edit.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3273 extends BaseEntity {

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
	private List<MyEntity3273> children = new ArrayList<>();
}