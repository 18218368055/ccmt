// *** CCMT通用函数 ***

/**
 * 打印提示消息
 */
function imsg(msg) {
	alert(msg);
}

/**
 * 打印正确消息
 */
function rmsg(msg) {
	alert(msg);
}

/**
 * 打印失败消息
 */
function fmsg(msg) {
	alert(msg);
}

/**
 * 打印错误消息
 */
function emsg(msg) {
	alert(msg);
}

/**
 * 是否提示框
 * @param msg
 * @param fn
 */
function cfMsg(msg, fn) {
	if (confirm(msg)) {
		fn();
	}
}

/**
 * 取得ctx
 */
function getCtx() {
	return $("#ctx").val();
}

///**
// * CCMT数据字典
// */
//var ccmtDd = parent.julyDd;
//
//(function($) {
//	/**
//	 * CCMT插件库
//	 */
//	$.ccmt = {
//		/**
//		 * CCMT的通用ajax提交，并提供一个简单的可防重复提交的实现
//		 * ag其它入参：
//		 * prFlag {string} 防重复提交的标识，唯一，对应值：true时不可操作，false：可操作
//		 * 会默认设置type、dataType、error
//		 */
//		ajax : function(ag) {
//			ag = ag || {};
//			var self = $.ccmt;
//			//防重复提交的相关操作
//			var prFlag = ag.prFlag;
//			var isPrFlag = asst.isNotEmpty(prFlag);
//			if (isPrFlag) {
//				var oldPrFlag = self.prFlagBox[prFlag];
//				//第一次请求执行
//				if (oldPrFlag) return false;
//				self.prFlagBox[prFlag] = true;
//			}
//			//默认配置
//			var aguse = {
//				type : "post",
//				dataType : "json",
//				error : function(err) {
//					//防重复提交的相关操作，操作异常时重置回该标识
//					if (isPrFlag) {
//						self.prFlagBox[prFlag] = false;
//					}
//					emsg("操作异常！");
//					console.error(err);
//				}
//			}
//			ag = $.extend(aguse, ag);
//			//用于操作成功的函数后做一些其它操作
//			var itSuccess = aguse.success;
//			aguse.success = function (data, textStatus, jqXHR) {
//				itSuccess(data, textStatus, jqXHR);
//				//防重复提交的相关操作，操作成功后重置回该标识
//				if (isPrFlag) {
//					self.resetPrFlag(prFlag);
//				}
//			}
//			$.ajax(aguse);
//		},
//		/**
//		 * 防重复提交的标识容器
//		 */
//		prFlagBox : {},
//		/**
//		 * 重置防重复提交的标识
//		 */
//		resetPrFlag : function(flag) {
//			var self = $.ccmt;
//			self.prFlagBox[flag] = false;
//		},
//	}
//	
//	//将一些重要函数直接植入jQuery对象
//	$.ccmtAjax = $.ccmt.ajax;
//	
//	/**
//	 * 分页控件
//	 * <pre>
//	 * 入参ag {}：
//	 * url : 必传，地址
//	 * data : 可选，{}格式，条件参数数据
//	 * before : 可选，fn()，翻页查询前的处理逻辑
//	 * callback : 必传，fn(data, pagination)，data：数据
//	 * 			  翻页查询后的回调函数。
//	 * </pre>
//	 */
//    $.fn.ccmtPage = function(ag) {    
//        ag = ag || {};
//        $(this).pagination({
//        	dataSource : ag.url,
//        	data : ag.data,
//    		ajax: {
//		        beforeSend: function() {
//		        	if (ag.before)
//		        		ag.before();
//		        }
//    		},
//    		callback: function(data, pagination){
//    			ag.callback(data, pagination);
//    		},
//    		locator: "data.list",
//    		totalNumberLocator : "data.total",
//    		pageSize: 2,
//    		alias : {
//    			pageNumber : "pageNum",
//    		},
//    		showGoInput: false,
//    		showGoButton: false,
//    		showPageNumbers: true,
//    	    showNavigator: true,
//    	    formatNavigator: '<%= currentPage %>/<%= totalPage %>页，共<%= totalNumber %>条',
//        });
//    }
//    
//    /**
//     * jQuery valudate通用实现
//     */
//    $.fn.ccmtValidate = function(ag) {
//    	var aguse = {
//    		/**
//    		 * 是否debug模式
//    		 */
//			debug: false,
//    		/**
//    		 * 验证失败的操作
//    		 */
//			showErrors : function(errorMap, errorList) {
//				//加输入框边框红色框效果
//    			if (errorList.length != 0) {
//    				var em = $(errorList[0].element);
//    				var row = em.parents(".efc-row");
//    				if (!row.hasClass("bad"))
//    					row.addClass("bad");
//    			}
//				this.defaultShowErrors();
//    		},
//    		/**
//    		 * 错误样式调整
//    		 */
//			errorPlacement: function(error, element) { 
//				var row = element.parents(".efc-row");
//				row.find(".alert").html(error)
//			},
//			/**
//			 * 验证成功的操作
//			 */
//			success : function(label) {
//				//移除输入框边框红色框效果
//				var row = label.parents(".efc-row");
//				row.removeClass("bad");
//			},
//    	}
//    	$.extend(aguse, ag);
//    	$(this).validate(aguse);
//    }
//})(jQuery);










