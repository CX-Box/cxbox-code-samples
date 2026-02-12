package org.demo.documentation.fields.datetimewithseconds.sorting;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

//dateTimeWithSecondsSorting
@Entity
@Table(name = "DateTimeWithSecondsSortingEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsSortingEntity extends BaseEntity {

	private LocalDateTime customField;

}