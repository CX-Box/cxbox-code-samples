package org.demo.documentation.dateytimewithseconds.validationannotation;

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
public class MyEntity167 extends BaseEntity {

	@Column
	private LocalDateTime customField;

}