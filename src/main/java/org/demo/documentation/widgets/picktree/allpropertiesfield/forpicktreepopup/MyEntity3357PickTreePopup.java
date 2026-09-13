package org.demo.documentation.widgets.picktree.allpropertiesfield.forpicktreepopup;

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
public class MyEntity3357PickTreePopup extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldColorSort;
	@Column
	private String customFieldRequired;
	@Column
	private String customFieldColorValidation;
	@Column
	private String customFieldDrilldown;
	@Column
	private Long customFieldColorConst;
	@Column
	private Long customFieldColor;
	@Column
	private String customFieldPlaceholder;

	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity3357PickTreePopup> children = new ArrayList<>();

}
