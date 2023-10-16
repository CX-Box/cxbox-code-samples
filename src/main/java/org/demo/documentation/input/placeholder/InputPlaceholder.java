package org.demo.documentation.input.placeholder;

import javax.persistence.Entity;
import javax.persistence.Table;
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
