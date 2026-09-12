package org.demo.documentation.widgets.picktree.actions.create;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picktree.actions.create.inlinepicktree.MyEntity3348InlinePick;
import org.demo.documentation.widgets.picktree.actions.create.picktree.MyEntity3348Pick;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3348 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity3348Pick customFieldEntity;
	@JoinColumn(name = "CUSTOM_FIELD_INLINE_PICKLIST_ID")
	@ManyToOne
	private MyEntity3348InlinePick customFieldInlinePicktreeEntity;
}