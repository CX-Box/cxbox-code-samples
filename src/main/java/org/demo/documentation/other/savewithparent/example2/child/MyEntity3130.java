package org.demo.documentation.other.savewithparent.example2.child;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.savewithparent.example2.parent.MyEntity3131;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3130 extends BaseEntity {
	@Column
	private String customField;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private MyEntity3131 customFieldEntity;
}