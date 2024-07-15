package org.demo.documentation.fields.input.placeholder;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "InputPlaceholder")
@Getter
@Setter
@NoArgsConstructor
public class InputPlaceholder extends BaseEntity {

	private String customField;

}
