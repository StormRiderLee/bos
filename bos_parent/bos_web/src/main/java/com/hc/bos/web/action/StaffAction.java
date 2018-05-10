package com.hc.bos.web.action;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hc.bos.domain.Staff;
import com.hc.bos.service.StaffService;
import com.hc.bos.utils.FastJsonUtil;
import com.hc.bos.utils.PageBean;
import com.hc.bos.web.action.base.BaseAction;

/**
 * 取派员管理
 * @author zhaoqx
 *
 */
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{
	@Autowired
	private StaffService staffService;
	
	/**
	 * 添加取派员
	 */
	public String add(){
		staffService.save(model);
		return "staffAdd";
	}
	
	//属性驱动，接收页面提交的分页参数
	private int page;
	private int rows;
	
	/**
	 * 分页查询方法
	 * @throws IOException 
	 */
	public String pageQuery() throws Exception{
		//创建离线提交查询对象
		staffService.pageQuery(pageBean);
		
		//使用json-lib将PageBean对象转为json，通过输出流写回页面中
		//JSONObject---将单一对象转为json
		//JSONArray----将数组或者集合对象转为json
		//指定哪些属性不需要转json
		this.json(pageBean);
		return NONE;
	}
	
	//属性驱动，接收页面提交的ids参数
	private String ids;
	
	/**
	 * 取派员批量删除
	 */
	public String deleteBatch(){
		staffService.deleteBatch(ids);
		return "staffAdd";
	}
	
	/**
	 * 修改取派员信息
	 */
	public String edit(){
		//显查询数据库，根据id查询原始数据
		Staff staff = staffService.findById(model.getId());
		//使用页面提交的数据进行覆盖
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		return "staffAdd";
	}
	
	/*public static void main(String[] args) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(2);
		pageBean.setPageSize(30);
		String json = JSONObject.fromObject(pageBean ).toString();
		System.out.println(json);
	}*/

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
