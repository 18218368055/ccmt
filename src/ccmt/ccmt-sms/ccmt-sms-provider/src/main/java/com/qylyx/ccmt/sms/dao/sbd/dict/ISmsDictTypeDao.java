package com.qylyx.ccmt.sms.dao.sbd.dict;

import java.util.List;

import com.qylyx.ccmt.sms.entity.sbd.dict.co.SmsDictTypeListCo;
import com.qylyx.ccmt.sms.entity.sbd.dict.dto.SmsDictTypeDto;
import com.qylyx.ccmt.sms.entity.sbd.dict.vo.SmsDictTypeVO;

/**
 * 数据字典类型dao
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsDictTypeDao {
	
	/**
	 * 获取系统使用的数据字典
	 * @return
	 */
	public List<SmsDictTypeDto> queryHdDict();
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return 受影响的行数
	 */
	public int save(SmsDictTypeVO vo);
	
	/**
	 * 查询列表
	 * @param co 条件
	 * @return
	 */
	public List<SmsDictTypeVO> queryList(SmsDictTypeListCo co);
}
