package org.demo.documentation.widgets.assoctree.customizationcolumns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3335Assoc extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldTest;
	@Column
	private Long customFieldNumber;
	@Column
	private String customFieldText;

	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity3335Assoc> children = new ArrayList<>();

}
