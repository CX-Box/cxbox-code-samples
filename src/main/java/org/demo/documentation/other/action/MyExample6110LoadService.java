package org.demo.documentation.other.action;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample6110LoadService {

	private final MyExample6110Repository  myExample6110Repository;

	@PostConstruct
	@Transactional
	public void init(){
		var myExample6110Entity = new MyExample6110Entity();
		myExample6110Repository.save(myExample6110Entity);

	}

}
