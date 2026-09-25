package org.demo.documentation.fields.picktree.placeholder;

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
public class MyEntity3287 extends BaseEntity {

	@JoinColumn(name = "CUSTOM_FIELD_ID")
	@ManyToOne
	private MyEntity3287Pick customFieldEntity;

	@JoinColumn(name = "CUSTOM_FIELD_RO_ID")
	@ManyToOne
	private MyEntity3287Pick customFieldROEntity;

}