package org.demo.documentation.fields.datetimewithseconds.validationdynamic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity322 extends BaseEntity {

	@Column
	private LocalDateTime customField;

	@Column
	private LocalDateTime customFieldAdditional;

}