package org.demo.documentation.date.validationdynamic;

import java.time.LocalDate;
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
public class MyEntity320 extends BaseEntity {

	@Column
	private LocalDate customField;

	@Column
	private LocalDate customFieldAdditional;

}