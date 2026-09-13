package org.demo.documentation.widgets.picktree.actions.cancelcreate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.basic.MyEntity3356Pick;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.oncancel.MyEntity3356PickOnCancel;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.postaction.MyEntity3356PickPostAction;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3356 extends BaseEntity {
	@Column
	private String customField;
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3356Pick customFieldPickTreeEntity;
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ON_CANCEL_ID")
	@ManyToOne
	private MyEntity3356PickOnCancel customFieldPickTreeOnCancelEntity;
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_POST_ACTION_ID")
	@ManyToOne
	private MyEntity3356PickPostAction customFieldPickTreePostActionEntity;
}