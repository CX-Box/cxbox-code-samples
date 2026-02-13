package org.demo.documentation.widgets.relationGraph;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.other.relationGraph.enums.TargetNodeTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity6150TestDataLoadService {

	@Autowired
	Myexample6150Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();

		java.util.function.LongFunction<String> color = v -> {
			if (v > 5000L) return "red";
			if (v > 1000L) return "black";
			return "gray";
		};

		// Root row (source = null) so frontend can "declare" the root node
		var root = repository.save(new Myexample6150()
				.setSourceNodeId(null)
				.setTargetNodeId("root")
				.setTargetNodeBgColorKey("gray")
				.setTargetNodeType(TargetNodeTypeEnum.MAIN)
				.setTargetNodeName("Root R1")
				.setEdgeDescription("Root node")
				.setEdgeValue("0")
				.setEdgeValueBgColorKey("gray")
		);

		root.setTargetNodeId(String.valueOf(root.getId()));
		repository.save(root);
	}

}