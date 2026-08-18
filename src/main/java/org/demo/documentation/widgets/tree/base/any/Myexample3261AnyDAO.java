package org.demo.documentation.widgets.tree.base.any;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
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
		return  getData(bc).stream()
				.filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public Page<Myexample3261AnyDTO> getList(BusinessComponent bc, QueryParameters queryParameters) {
		return new PageImpl<>(getData(bc));
	}

	@Override
	public Myexample3261AnyDTO create(BusinessComponent bc, Myexample3261AnyDTO entity){
		throw new IllegalStateException();
	}

	@Override
	public Myexample3261AnyDTO update(BusinessComponent bc, Myexample3261AnyDTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public void delete(BusinessComponent bc) {
		throw new IllegalStateException();	}

	public List<Myexample3261AnyDTO> getData(BusinessComponent bc) {
		//Page size
		String pageStr = bc.getParameters().getParameter("_page");

		//Limit
		String limitStr = bc.getParameters().getParameter("_limit");

		int page = (pageStr != null) ? Integer.parseInt(pageStr) : 0;
		int limit = (limitStr != null) ? Integer.parseInt(limitStr) : 20;
		int offset = page * limit;
		return repository.allDepartmentUsers(offset,limit).stream().map(
				entity -> {
					Myexample3261AnyDTO myexample3261AnyDTO= new Myexample3261AnyDTO()
							.setDepartment(entity.departmentName())
							.setParentId(entity.parentId())
							.setIsLeaf(entity.isLeaf())
							.setLastName(entity.lastName())
							.setFullName(entity.fullName())
							.setFirstName(entity.firstName())
							.setMiddleName(entity.middleName());
					myexample3261AnyDTO.setId(entity.id());
					return myexample3261AnyDTO;
				}).toList();

	}
}
