// *** 工具函数库 ***

/**
 * july工具函数库
 */
var july = {};

(function($){
	//==================== 值 ====================
	$.extend(july, {
		/**
		 * 将值转为int，在转换不出int（即NaN）时，返回0
		 */
		toIntZero : function(val) {
			var result = val ? this.parseInt(val) : Number.NaN;
			return isNaN(result) ? 0 : result;
		},
		
		/**
		 * 将值转为float，在转换不出float（即NaN）时，返回0
		 */
		toFloatZero : function(val) {
			var result = val ? this.parseFloat(val) : Number.NaN;
			return isNaN(result) ? 0 : result;
		},
	});
	//==================== 值 End ====================
	
	//==================== 验证 ====================
	$.extend(july, {
		/**
		 * 是否为空
		 */
		isEmpty : function(val) {
			return val == undefined || val == null || val == "";
		},
		
		/**
		 * 是否不为空
		 */
		isNotEmpty : function(val) {
			return !this.isEmpty(val);
		},
	});
	//==================== 验证 End ====================
	
	//==================== 表单的相关处理 ====================
	/**
	 * 用于此表单自动构建的自增id后缀
	 */
	var autoFormId = 0;
	
	$.extend(july, {
		/**
		 * 构建出一个form表单
		 * ag参数：
		 *   url ： 必填，地址
		 * 	 method ： 选填，默认post,提交方式	
		 *   data{} ：　选填，参数数据
		 *   id ： 选填，form节点id,默认autoForm + autoForm.autoFormId(自增)
		 */
		formBuild : function(ag) {
			ag = ag || {};
			var id = ag["id"] || ("autoForm" + autoFormId++);
			var url = ag["url"];
			var method = ag["method"] || "post";
			var data = ag["data"];
			var form = $("<form></form>");
			form.attr("id",id);
			form.attr("action",url);
			form.attr("method",method);
			if (july.isNotEmpty(data)) {
				for (var key in data) {
					var param = "<input type='hidden' name='" + key + "' value='" + data[key] + "'/>";
					form.append(param);
				}
			}
			return form;
		},
		
		/**
		 * 构建出一个form表单，并写某节点下，默认body后
		 * ag参数：
		 *   url ： 必填，地址
		 * 	 method ： 选填，默认post,提交方式	
		 *   data{} ：　选填，参数数据
		 *   id ： 选填，form节点id,默认autoForm + autoForm.autoFormId(自增)
		 *   root ： 选填，默认body，写于哪个节点下
		 *   
		 */
		formBuildWrite : function(ag) {
			ag = ag || {};
			var root = ag["root"] || "body"
			var form = this.formBuild(ag);
			$(root).append(form);
			return form;
		},
		
		/**
		 * 构建出一个form表单，并写某节点下，默认body后，然后提交
		 * ag参数：
		 *   url ： 必填，地址
		 * 	 method ： 选填，默认post,提交方式	
		 *   data{} ：　选填，参数数据
		 *   id ： 选填，form节点id,默认autoForm + autoForm.autoFormId(自增)
		 *   root ： 选填，默认body，写于哪个节点下
		 */
		formBuildSubmit : function(ag) {
			var form = this.formBuildWrite(ag);
			form.submit();
		},
		/**
		 * 构建出一个form表单，并写某节点下，默认body后，然后提交
		 */
		formBuildSubmit : function(url, data) {
			var form = this.formBuildWrite({
				url : url,
				data : data
			});
			form.submit();
		},
	});
	//==================== 表单的相关处理 End ====================
	
	//==================== href的相关处理 ====================
	$.extend(july, {
		/**
		 * location.href
		 * @param url 必填，地址
		 * @param data {} 选填,数据
		 */
		href : function(url, data) {
			if (july.isNotEmpty(data)) {
				var dataParams;
				for (var key in data) {
					if (undefined == dataParams)
						dataParams = "?";
					else
						dataParams += "&";
					dataParams += key + "=" + data[key];
				}
				url += dataParams;
			}
			window.location.href = url;
		}
	});
	//==================== href的相关处理 End ====================
	
	$.extend(july, {
		/**
		 * july的通用ajax提交，并提供一个简单的可防重复提交的实现
		 * ag其它入参：
		 * prFlag {string} 防重复提交的标识，唯一，对应值：true时不可操作，false：可操作
		 * 会默认设置type、dataType
		 */
		ajax : function(ag) {
			ag = ag || {};
			var self = this;
			//防重复提交的相关操作
			var prFlag = ag.prFlag;
			var isPrFlag = july.isNotEmpty(prFlag);
			if (isPrFlag) {
				var oldPrFlag = self.ajaxPrFlagBox[prFlag];
				//第一次请求执行
				if (oldPrFlag) return false;
				self.ajaxPrFlagBox[prFlag] = true;
			}
			//默认配置
			var aguse = {
				type : "post",
				dataType : "json",
			}
			
			ag = $.extend(aguse, ag);
			
			//用于操作失败的函数后额外做一些其它操作
			var itError = aguse.error;
			if (itError) {
				aguse.error = function (XMLHttpRequest, textStatus, errorThrown) {
					//防重复提交的相关操作，操作异常时重置回该标识
					if (isPrFlag) {
						self.ajaxPrFlagBox[prFlag] = false;
					}
					itError(XMLHttpRequest, textStatus, errorThrown);
				}
			}
			
			//用于操作成功的函数后额外做一些其它操作
			var itSuccess = aguse.success;
			if (itSuccess) {
				aguse.success = function (data, textStatus, jqXHR) {
					itSuccess(data, textStatus, jqXHR);
					//防重复提交的相关操作，操作成功后重置回该标识
					if (isPrFlag) {
						self.ajaxResetPrFlag(prFlag);
					}
				}
			}
			
			$.ajax(aguse);
		},
		/**
		 * 防重复提交的标识容器
		 */
		ajaxPrFlagBox : {},
		/**
		 * 重置防重复提交的标识
		 */
		ajaxResetPrFlag : function(flag) {
			var self = this;
			self.ajaxPrFlagBox[flag] = false;
		},
	});
	
	//==================== 其它 ====================
	$.extend(july, {
		/**
		 * 如果字段与某一比较值相等，则返回相应的值，如果到最后没匹配上则返回缺省值，未设置缺省值则返回null
		 * @param decode(字段，比较1，值1，比较2，值2，.....，比较n，值n，[缺省值])
		 * @returns 匹配的值
		 */
		decode : function() {
			var len = arguments.length;
			if (len <= 2)
				return null;
			var curIndex = 1;
			while (true){
				if (curIndex > len - 1){  //没值可遍历的值了，return
					return null;
				} else if(curIndex == len-1){  //只剩最后一个缺省值了，如果有设，返回缺省值
					return arguments[len-1];
				}else{ 
					if(arguments[0] == arguments[curIndex])
						return arguments[curIndex + 1];
					else
						curIndex += 2;
				}
			}
		},
	});
	//==================== 其它 End ====================
	
	
	
	//******************************** $.fn的相关函数 **************************************
	
	/**
	 * 序列表单内容为{}格式数据，和$.serialize()同理，只是返回数据格式不一样，
	 * 以表单的name属性值作为{}的key，value值作为{}的value
	 * 特别说明：由于{}存在同key会覆盖的情况，所以在此特殊处理，会在key值后带上下标，如{"ids[0]", "101", "ids[1]", "102"}
	 */
	$.fn.serializeMap = function() {
		var arr = $(this).serializeArray();
		//结果集
		var result = {};
		//一个判断是否有同名key的标识容器
		var flagBox = {};
		$.each(arr, function() {
			var key = this.name;
			var val = this.value;
			
			var keyIndex = flagBox[key];
			//第一次的key，直接放入结果集
			if (keyIndex == undefined) {
				result[key] = val;
				keyIndex = 0;
			} else {  //多次key，进行特殊处理，为key带上下标
				//第一次重复key，将原先的普通key重置为带上下标的
				if (keyIndex == 0) {
					result[key + "[0]"] = result[key];
					delete result[key];
				}
				//为多次key带上下标
				keyIndex++;
				result[key + "[" + keyIndex + "]"] = val;
			}
			
			//放入标识容器
			flagBox[key] = keyIndex;
		});
		
		return result;
	};
	
	/**
	 * 将所有值进行前后空格的去除，再进行序列化
	 */
	$.fn.serializeTrim = function() {
		var arr = $(this).serializeArray();
		$.each(arr, function() {
			//去除前后空格
			this.value = $.trim(this.value);
		});
		return jQuery.param(arr);
	}
	
	/**
	 * 将某输入框的内容进行前后空格的去除
	 */
	$.fn.toTrim = function() {
		$(this).val($.trim($(this).val()));
	}
	
})(jQuery);

