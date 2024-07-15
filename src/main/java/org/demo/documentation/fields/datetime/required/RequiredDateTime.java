package org.demo.documentation.fields.datetime.required;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//requiredDateTime
@Entity
@Table(name = "RequiredDateTime")
@Getter
@Setter
@NoArgsConstructor
public class RequiredDateTime extends BaseEntity {

	private LocalDateTime customField;

}