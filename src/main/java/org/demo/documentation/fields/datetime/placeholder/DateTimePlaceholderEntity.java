package org.demo.documentation.fields.datetime.placeholder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

//dateTimePlaceholder
@Entity
@Table(name = "DateTimePlaceholderEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimePlaceholderEntity extends BaseEntity {


	@Column
	private LocalDateTime customField;

}