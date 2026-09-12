package org.demo.documentation.widgets.picktree.actions.other.createcustomsave;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3349 extends BaseEntity {


	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity3349Pick customFieldEntity;
	@Column
	private String customFieldRequred;
}