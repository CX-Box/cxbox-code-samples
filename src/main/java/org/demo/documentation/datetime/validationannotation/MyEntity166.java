package org.demo.documentation.datetime.validationannotation;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity166 extends BaseEntity {

	@Column
	private LocalDateTime customField;

}