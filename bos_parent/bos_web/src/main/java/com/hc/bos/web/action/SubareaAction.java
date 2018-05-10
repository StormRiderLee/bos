package com.hc.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hc.bos.domain.Subarea;
import com.hc.bos.service.SubareaService;
import com.hc.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea>{
	@Autowired
	private SubareaService subareaService;
	public String save(){
		subareaService.save(model);
		return "subareaAdd";
	}
}
