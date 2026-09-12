package org.demo.documentation.widgets.picktree.actions.save;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picktree.actions.save.forpicktreepopup.MyEntity3355Pick;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3355 extends BaseEntity {
	@Column
	private String customField;
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3355Pick customFieldPickTreeEntity;
}