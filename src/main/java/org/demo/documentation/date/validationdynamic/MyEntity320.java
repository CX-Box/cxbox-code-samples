package org.demo.documentation.date.validationdynamic;

import java.time.LocalDateTime;
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
public class MyEntity320 extends BaseEntity {

	@Column
	private LocalDateTime  customField;

	@Column
	private LocalDateTime  customFieldAdditional;

}