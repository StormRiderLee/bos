package com.hc.bos.web.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.hc.bos.domain.Region;
import com.hc.bos.utils.FastJsonUtil;
import com.hc.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	private static final long serialVersionUID = -2626458612928471782L;
	protected PageBean pageBean = new PageBean();
	protected DetachedCriteria detachedCriteria = null;
	public void setPage(int page) {
		pageBean.setCurrentPage(page);
	}
	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}
	public void json(Object pageBean){
		HttpServletResponse response = ServletActionContext.getResponse();
		String jsonString = FastJsonUtil.toJSONString(pageBean);
		FastJsonUtil.write_json(response, jsonString);
	}
	public void json(List pageBean){
		HttpServletResponse response = ServletActionContext.getResponse();
		String jsonString = FastJsonUtil.toJSONString(pageBean);
		FastJsonUtil.write_json(response, jsonString);
	}
	protected T model;
	@Override
	public T getModel() {
		return model;
	}
	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) types[0];
		detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
		try {
			model = entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
