package org.demo.documentation.fields.richtext.height;

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
public class MyEntity436 extends BaseEntity {

	/** Stores markdown, so it needs far more room than a plain one-line text field. */
	@Column(length = 10000)
	private String customField;

}
