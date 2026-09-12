package org.demo.documentation.widgets.picktree.base.onefield;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picktree.base.onefield.picktreepopup.MyEntity3351Pick;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3351 extends BaseEntity {
	@Column
	private String customField;
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3351Pick customFieldPickTreeEntity;
	@JoinColumn(name = "CUSTOM_FIELD_INLINE_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3351Pick customFieldInlinePickTreeEntity;
}