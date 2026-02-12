package org.demo.documentation.widgets.picklist.base.onefield;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079Pick;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3079 extends BaseEntity {
	@Column
	private String customField;
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3079Pick customFieldPickListEntity;
	@JoinColumn(name = "CUSTOM_FIELD_INLINE_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3079Pick customFieldInlinePickListEntity;
}