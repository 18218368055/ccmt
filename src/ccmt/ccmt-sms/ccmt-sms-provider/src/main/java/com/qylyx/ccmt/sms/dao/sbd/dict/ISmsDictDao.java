package com.qylyx.ccmt.sms.dao.sbd.dict;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qylyx.ccmt.sms.entity.sbd.dict.bo.SmsDictDto;
import com.qylyx.ccmt.sms.entity.sbd.dict.vo.SmsDictVO;

/**
 * 数据字典dao
 * 
 * @author Qiaoxin.Hong
 *
 */
public interface ISmsDictDao {
	
	public List<SmsDictDto> queryHdDict(@Param("typeCode") String typeCode);
	
	/**
	 * 新增
	 * @param vo 数据对象
	 * @return 受影响的行数
	 */
	public int save(SmsDictVO vo);
	
	/**
	 * 查询某组数据字典
	 * @param typeCode 数据字典类型代码
	 * @return
	 */
	public List<SmsDictVO> queryList(@Param("typeCode") String typeCode);
}
