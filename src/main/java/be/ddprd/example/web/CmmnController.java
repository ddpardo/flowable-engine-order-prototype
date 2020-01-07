package be.ddprd.example.web;

import java.util.Collections;
import java.util.List;

import org.flowable.cmmn.api.CmmnRepositoryService;
import org.flowable.cmmn.api.CmmnRuntimeService;
import org.flowable.cmmn.api.runtime.CaseInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cmmn/")
public class CmmnController {

	private final CmmnRuntimeService cmmnRuntimeService;
	
	public CmmnController(CmmnRuntimeService cmmnRuntimeService) {
		this.cmmnRuntimeService = cmmnRuntimeService;
	}
	
	
	
	@PostMapping("/start/{cmmnDefinitionKey}")
	public String startInstance(@PathVariable String cmmnDefinitionKey) {
		CaseInstance caseInstance = cmmnRuntimeService.createCaseInstanceBuilder()
			.caseDefinitionKey(cmmnDefinitionKey)
			.start();
		
		return caseInstance.getId();
	}
	
}
