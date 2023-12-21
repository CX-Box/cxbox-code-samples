package org.demo.documentation.widgets.form.showcondition.byparententity.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.form.showcondition.byparententity.parent.MyEntity3007;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3006 extends BaseEntity {

	@Column
	private String customField;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private MyEntity3007 customFieldEntity;

}