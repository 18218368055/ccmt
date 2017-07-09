package com.qylyx.ccmt.sms.controller.sbd.dict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qylyx.ccmt.sms.entity.sbd.dict.co.SmsDictTypeListCo;
import com.qylyx.ccmt.sms.entity.sbd.dict.vo.SmsDictTypeVO;
import com.qylyx.ccmt.sms.service.sbd.dict.ISmsDictTypeService;
import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.framework.base.entity.page.Page;
import com.qylyx.remex.framework.base.entity.page.PageCo;

/**
 * 数据字典类型controller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("数据字典类型")
@Controller
@RequestMapping("/sms/sbd/dictType/")
public class SmsDictTypeController {
	
	@Autowired
	ISmsDictTypeService smsDictTypeService;
	
	/**
	 * 到列表界面
	 * @return
	 */
	@Salog("到列表界面")
	@RequestMapping("toList")
	public String toList() {
		return "sms/sbd/dict/dictTypeList";
	}
	
	/**
	 * 查询列表
	 * @param pageCo 分页参数
	 * @param co 条件
	 * @return
	 */
	@Salog("查询列表")
	@RequestMapping("queryList")
	@ResponseBody
	public Object queryList(PageCo pageCo, SmsDictTypeListCo co) {
		Page<SmsDictTypeVO> page = smsDictTypeService.queryList(pageCo, co).getDataWeb();
		return page;
	}
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	@Salog("新增")
	@RequestMapping("add")
	@ResponseBody
	public Object add(SmsDictTypeVO vo) {
		vo = smsDictTypeService.add(vo).getDataWeb();
		return "";
	}
}
