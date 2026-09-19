package org.demo.documentation.widgets.statsblock.showcondition.byparententity.child;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.statsblock.showcondition.byparententity.parent.MyEntity4232;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity4233 extends BaseEntity {

	@Column
	private String title;

	@Column
	private Long value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private MyEntity4232 customFieldEntity;

}
