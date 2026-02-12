package org.demo.documentation.fields.datetime.filtration;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "DateTimeFiltration")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeFiltration extends BaseEntity {

	private LocalDateTime customField;

}