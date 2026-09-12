package org.demo.documentation.widgets.picktree.colortitle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Pick;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3341 extends BaseEntity {
	@Column
	private String customField;
	@JoinColumn(name = "CUSTOM_FIELD_PICKLIST_ID")
	@ManyToOne
	private MyEntity3342 customFieldPicktreeEntity;
	@JoinColumn(name = "CUSTOM_FIELD_PICKLIST_COLOR_CONST_ID")
	@ManyToOne
	private MyEntity3342Pick customFieldPicktreeColorConstEntity;
}