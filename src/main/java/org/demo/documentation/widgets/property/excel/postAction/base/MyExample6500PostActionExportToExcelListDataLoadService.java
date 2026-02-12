package org.demo.documentation.widgets.property.excel.postAction.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.model.core.dao.JpaDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyExample6500PostActionExportToExcelListDataLoadService {

	private final JpaDao dao;

	private final InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		int size = 1000;
		List<MyExample6500PostActionExportToExcelListEntity> data = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			MyExample6500PostActionExportToExcelListEntity entity = new MyExample6500PostActionExportToExcelListEntity();
			entity.setTestData("testData" + i);
			data.add(entity);
		}
		dao.saveAll(data);
	}


}