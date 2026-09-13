package org.demo.documentation.widgets.property.excel.postAction.base;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.model.core.entity.BaseEntity;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "MY_EXAMPLE6500_POST_ACTION_EXPORT_TO_EXCEL_LIST_ENTITY")
public class MyExample6500PostActionExportToExcelListEntity extends BaseEntity {

	@Column(name = "TEST_DATA")
	public String testData;

	/** The tree tab: the parent record, empty for a root record. */
	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyExample6500PostActionExportToExcelListEntity> children = new ArrayList<>();
}
