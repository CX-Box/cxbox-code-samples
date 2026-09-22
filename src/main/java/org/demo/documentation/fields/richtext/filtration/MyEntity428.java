package org.demo.documentation.fields.richtext.filtration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity428 extends BaseEntity {

	/** Stores markdown, so it needs far more room than a plain one-line text field. */
	@Column(length = 10000)
	private String customField;

}