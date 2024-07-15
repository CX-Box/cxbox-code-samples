package org.demo.documentation.fields.input.sorting;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputSort
@Entity
@Table(name = "InputSort")
@Getter
@Setter
@NoArgsConstructor
public class InputSort extends BaseEntity {

	private String customField;

}
