package org.demo.documentation.widgets.tree.base.any;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.tree.data.departments.DepartmentUsersPrj;
import org.demo.documentation.widgets.tree.data.departments.MydepartmensRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class Myexample3261AnyDAO extends AbstractAnySourceBaseDAO<Myexample3261AnyDTO> {

	private final MydepartmensRepository repository;

	@Override
	public String getId(Myexample3261AnyDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(String id, Myexample3261AnyDTO entity) {
		entity.setId(id);
	}

	@Override
	public Myexample3261AnyDTO getByIdIgnoringFirstLevelCache(BusinessComponent bc) {
		String id = bc.getId();
		String[] parts = id.split("-");
		String departmentId = parts[0];
		return getData(bc, departmentId).stream().filter(s -> Objects.equals(s.getId(), id)).findFirst().orElse(null);

	}

	@Override
	public Page<Myexample3261AnyDTO> getList(BusinessComponent bc, QueryParameters queryParameters) {
		return new PageImpl<>(getData(bc, null));
	}

	@Override
	public Myexample3261AnyDTO create(BusinessComponent bc, Myexample3261AnyDTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public Myexample3261AnyDTO update(BusinessComponent bc, Myexample3261AnyDTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public void delete(BusinessComponent bc) {
		throw new IllegalStateException();
	}

	public List<Myexample3261AnyDTO> getData(BusinessComponent bc, String deptId) {

		String pageStr = bc.getParameters().getParameter("_page");
		String limitStr = bc.getParameters().getParameter("_limit");
		String isLeafParam = bc.getParameters().getParameter("parentId.specified");
		String parentId = bc.getParameters().getParameter("parentId.equals");

		int page = parseOrDefault(pageStr, 0);
		int limit = parseOrDefault(limitStr, 20);
		int offset = page == 0 ? 0 : (page - 1) * limit;

		List<DepartmentUsersPrj> entities;
		if (deptId != null) {
			entities = repository.allDepartmentUsersDeptId(offset, limit, deptId);
		} else if (isLeafParam != null) {
			entities = repository.allDepartmentUsersisLeaf(offset, limit, Boolean.parseBoolean(isLeafParam));
		}else if (parentId != null) {
			String[] parts = parentId.split("-");
			parentId = parts[0];
			entities = repository.allDepartmentUsersParentId(offset, limit, parentId);
		}  else {
			entities = repository.allDepartmentUsers(offset, limit);
		}

		return entities.stream()
				.map(this::toDTO)
				.toList();
	}

	private Myexample3261AnyDTO toDTO(DepartmentUsersPrj entity) {
		Myexample3261AnyDTO myexample3261AnyDTO = new Myexample3261AnyDTO()
				.setDepartment(entity.departmentName())
				.setParentId(entity.parentId())
				.setIsLeaf(entity.isLeaf())
				.setLastName(entity.lastName())
				.setFullName(entity.fullName())
				.setFirstName(entity.firstName())
				.setMiddleName(entity.middleName());
		myexample3261AnyDTO.setId(entity.id());
		return myexample3261AnyDTO;
	}

	private int parseOrDefault(String value, int defaultValue) {
		if (value == null || value.trim().isEmpty()) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(value.trim());
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

}
