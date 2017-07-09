package com.qylyx.ccmt.sms.controller.sbd.dict;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qylyx.ccmt.sms.entity.sbd.dict.vo.SmsDictVO;
import com.qylyx.ccmt.sms.service.sbd.dict.ISmsDictService;
import com.qylyx.july.salog.annotation.Salog;

/**
 * 数据字典controller
 * 
 * @author Qiaoxin.Hong
 *
 */
@Salog("数据字典")
@Controller
@RequestMapping("/sms/sbd/dict/")
public class SmsDictController {
	
	@Autowired
	ISmsDictService smsDictService;
	
	/**
	 * 到列表界面
	 * @param typeCode
	 * @return
	 */
	@Salog("到列表界面")
	@RequestMapping("toList")
	public String toList(Model model, String typeCode) {
		model.addAttribute("typeCode", typeCode);
		return "sms/sbd/dict/dictList";
	}
	
	/**
	 * 查询某组数据字典
	 * @param typeCode 数据字典类型代码
	 * @return
	 */
	@Salog("查询某组数据字典")
	@RequestMapping("queryList")
	@ResponseBody
	public Object queryList(String typeCode) {
		List<SmsDictVO> list = smsDictService.queryList(typeCode).getDataWeb();
		return list;
	}
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return
	 */
	@Salog("新增")
	@RequestMapping("add")
	@ResponseBody
	public Object add(SmsDictVO vo) {
		vo = smsDictService.add(vo).getDataWeb();
		return "";
	}
}
