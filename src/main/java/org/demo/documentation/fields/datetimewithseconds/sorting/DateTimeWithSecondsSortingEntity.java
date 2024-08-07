package org.demo.documentation.fields.datetimewithseconds.sorting;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsSorting
@Entity
@Table(name = "DateTimeWithSecondsSortingEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsSortingEntity extends BaseEntity {

	private LocalDateTime customField;

}