package org.demo.documentation.other.savewithparent.example5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "DOCUMENT")
@EqualsAndHashCode(of = {}, callSuper = true)
public class TaskDocument extends BaseEntity {

	@Column
	private String fileId;

	@Column
	private String file;

	@ManyToOne
	private Task task;
}
