package org.demo.documentation.widgets.picktree.actions.delete;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picktree.actions.delete.forpicktreepopup.MyEntity3354Pick;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3354 extends BaseEntity {
	@Column
	private String customField;
	@JoinColumn(name = "CUSTOM_FIELD_DELETE_ID")
	@ManyToOne
	private MyEntity3354Pick customFieldDeleteEntity;
}