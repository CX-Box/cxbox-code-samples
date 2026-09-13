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

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class Myexample3261AnyDAO extends AbstractAnySourceBaseDAO<Myexample3261AnyDTO> {

	private final MydepartmensRepository repository;
	private static final int DEFAULT_PAGE = 1;
	private static final int DEFAULT_LIMIT = 20;

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
		if (id == null || !id.contains("-")) {
			return null;
		}

		String departmentId = extractDepartmentId(id);
		return getData(bc, departmentId).stream()
				.filter(dto -> Objects.equals(dto.getId(), id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public Page<Myexample3261AnyDTO> getList(BusinessComponent bc, QueryParameters queryParameters) {
		List<Myexample3261AnyDTO> data = getData(bc, null);
		return new PageImpl<>(data);
	}

	@Override
	public Myexample3261AnyDTO create(BusinessComponent bc, Myexample3261AnyDTO entity) {
		throw new UnsupportedOperationException("Create operation is not supported");
	}

	@Override
	public Myexample3261AnyDTO update(BusinessComponent bc, Myexample3261AnyDTO entity) {
		throw new UnsupportedOperationException("Update operation is not supported");
	}

	@Override
	public void delete(BusinessComponent bc) {
		throw new UnsupportedOperationException("Delete operation is not supported");
	}

	public List<Myexample3261AnyDTO> getData(BusinessComponent bc, String deptId) {
		PaginationParams pagination = extractPaginationParams(bc);
		FilterParams filters = extractFilterParams(bc);

		List<DepartmentUsersPrj> entities = getData(pagination, filters, deptId);

		return entities.stream()
				.map(this::toDTO)
				.toList();
	}



	private PaginationParams extractPaginationParams(BusinessComponent bc) {
		String pageStr = bc.getParameters().getParameter("_page");
		String limitStr = bc.getParameters().getParameter("_limit");

		int page = parseOrDefault(pageStr, DEFAULT_PAGE);
		int limit = parseOrDefault(limitStr, DEFAULT_LIMIT);
		int offset = (page - 1) * limit;

		return new PaginationParams(offset, limit);
	}

	private FilterParams extractFilterParams(BusinessComponent bc) {
		String isLeafParam = bc.getParameters().getParameter("parentId.specified");
		String parentIdParam = bc.getParameters().getParameter("parentId.equals");

		return new FilterParams(
				isLeafParam != null ? Boolean.parseBoolean(isLeafParam) : null,
				parentIdParam
		);
	}

	private List<DepartmentUsersPrj> getData(PaginationParams pagination,
	                                         FilterParams filters,
	                                         String deptId) {
		int offset = pagination.offset();
		int limit = pagination.limit();


		if (deptId != null) {
			return repository.allDepartmentUsersDeptId(offset, limit, deptId);
		}

		if (filters.isLeaf() != null) {
			return repository.allDepartmentUsersisLeaf(offset, limit, filters.isLeaf());
		}

		if (filters.parentId() != null && !filters.parentId().isEmpty()) {
			String parentIdExtract = extractDepartmentId(filters.parentId());
			return	repository.allDepartmentUsersParentId(offset, limit,parentIdExtract);
		}

		return repository.allDepartmentUsers(offset, limit);
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
		if (value == null || value.isBlank()) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(value.trim());
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	private String extractDepartmentId(String compositeId) {
		if (compositeId == null || !compositeId.contains("-")) {
			return compositeId;
		}
		return compositeId.split("-")[0];
	}

	private record PaginationParams(int offset, int limit) {}

	private record FilterParams(Boolean isLeaf, String parentId) {}
}