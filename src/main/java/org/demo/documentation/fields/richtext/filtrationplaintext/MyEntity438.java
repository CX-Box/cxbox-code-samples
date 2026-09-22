package org.demo.documentation.fields.richtext.filtrationplaintext;

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
public class MyEntity438 extends BaseEntity {

	/** Stores markdown, so it needs far more room than a plain one-line text field. */
	@Column(length = 10000)
	private String customField;

	/**
	 * Only the letters and digits of customField, the database computes it (PostgreSQL).
	 * The filter searches this column, so formatting marks do not get in the way.
	 */
	@Column(insertable = false, updatable = false,
			columnDefinition = "text GENERATED ALWAYS AS (regexp_replace(custom_field, '[^[:alnum:]]', '', 'g')) STORED")
	private String customFieldPlain;

}