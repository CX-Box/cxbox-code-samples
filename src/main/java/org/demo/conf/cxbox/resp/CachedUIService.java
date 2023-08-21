package org.demo.conf.cxbox.resp;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.cxbox.api.data.dictionary.CoreDictionaries;
import org.cxbox.api.data.dictionary.LOV;
import org.cxbox.api.service.tx.TransactionService;
import org.cxbox.core.service.ResponsibilitiesService;
import org.cxbox.core.service.impl.UIServiceImpl;
import org.cxbox.core.service.impl.UserRoleService;
import org.cxbox.model.core.dao.JpaDao;
import org.cxbox.model.core.entity.User;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("uIServiceImpl")
@Primary
public class CachedUIService extends UIServiceImpl {

	private final AdditionalCache additionalCache;

	public CachedUIService(ObjectMapper objectMapper,
			ResponsibilitiesService responsibilitiesService,
			UserRoleService userRoleService, JpaDao jpaDao, UICache uiCache,
			CacheManager cacheManager, TransactionService txService, AdditionalCache additionalCache) {
		super(objectMapper, responsibilitiesService, userRoleService, jpaDao, uiCache, cacheManager, txService);
		this.additionalCache = additionalCache;
	}

	@Override
	public List<String> getViews(final String screenName, final User user, final LOV userRole) {
		final Set<String> responsibilities = getResponsibilities(user, userRole).keySet();
		final boolean getAll = Objects.equals(userRole, CoreDictionaries.InternalRole.ADMIN) || isCommonScreen(screenName);
		Set<String> screenViewsFromNavigation = additionalCache.getAllScreenViewsReferencedInNavigation().get(screenName);
		return screenViewsFromNavigation.stream().distinct().filter(e -> getAll || responsibilities.contains(e)).collect(
				Collectors.toList());
	}


}
