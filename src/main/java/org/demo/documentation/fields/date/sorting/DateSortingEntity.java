package org.demo.documentation.fields.date.sorting;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Table(name = "DateSortingEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateSortingEntity extends BaseEntity {

	private LocalDateTime customField;

}