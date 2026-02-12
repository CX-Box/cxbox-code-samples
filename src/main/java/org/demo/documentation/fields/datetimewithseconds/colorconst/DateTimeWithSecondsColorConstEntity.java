package org.demo.documentation.fields.datetimewithseconds.colorconst;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

//dateTimeWithSecondsColorConst
@Entity
@Table(name = "DateTimeWithSecondsColorConstEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsColorConstEntity extends BaseEntity {

	private LocalDateTime customField;

	@Column
	private String dsfds;

}