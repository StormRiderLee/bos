package com.hc.bos.web.action;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ctc.wstx.util.StringUtil;
import com.hc.bos.domain.Region;
import com.hc.bos.service.RegionService;
import com.hc.bos.utils.FastJsonUtil;
import com.hc.bos.utils.PageBean;
import com.hc.bos.utils.PinYin4jUtils;
import com.hc.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
/**
 * 区域管理
 * @author Administrator
 *
 */
public class RegionAction extends BaseAction<Region>{
	private String regionFile;
	@Autowired
	private RegionService regionService;
	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}
	public void setRegionFile(String regionFile) {
		this.regionFile = regionFile;
	}
	//导入
	public String importSC() throws Exception{
		//System.out.println(regionFile);
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("D:\\项目\\bos\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls"));
		HSSFSheet sheetAt = workbook.getSheetAt(0);
		List<Region> list = new ArrayList<Region>();
		for (Row row : sheetAt) {
			int rowNum = row.getRowNum();
			if(rowNum==0){
				continue;
			}
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			Region region = new Region(id,province,city,district,postcode,null,null,null);
			province = province.substring(0, province.length() - 1);
			city = city.substring(0, city.length() - 1);
			district = district.substring(0, district.length() - 1);
			
			String info = province + city + district;
			
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);
			//System.out.println(shortcode);
			
			//城市编码---->>shijiazhuang
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");
			region.setShortcode(shortcode);
			region.setCitycode(citycode);
			//System.out.println(citycode);
			list.add(region);
		}
		regionService.save(list);
		return null;
	}
	public String pageQuery(){
		regionService.pageQuery(pageBean);
		this.json(pageBean);
		return null;
	}
	private String q;
	public void setQ(String q) {
		this.q = q;
	}
	public String listajax(){
		List<Region> list = null;
		if(StringUtils.isNoneBlank(q)){
			list = regionService.findListByq(q);
		}else{
			list = regionService.findAll();
		}
		this.json(list);
		return null;
	}
}
