//*** july数据字典 ***

/**
 * july数据字典
 */
var julyDd = {
	/**
	 * july数据字典设置参数
	 */
	setting : {},
	/**
	 * 初始化数据字典
	 */
	init : function(ag) {
		ag = ag || {};
		$.extend(this.setting, ag);
	},
	/**
	 * 取得所有的数据
	 */
	source : function() {
		return this.setting.source || {};
	},
	/**
	 * 根据类型编码取得一组数据字典
	 */
	dictGroup : function(typeCode) {
		var source = this.source();
		for (var key in source) {
			if (typeCode == source[key].typeCode)
				return source[key].itemList;
		}
		return {};
	},
	/**
	 * 翻译数据字典
	 */
	tran : function(key, code) {
		var dict = this.dictGroup(code)[key];
		if (dict)
			return dict.name || "";
		return "";
	},
	
}