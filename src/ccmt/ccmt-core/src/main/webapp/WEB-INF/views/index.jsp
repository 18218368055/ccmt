<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CCMT首页</title>
</head>
<body>
	CCMT index !!!!
	
	<script type="text/javascript">
		$.ajax({
			url : "test",
			dataType : "json",
			success : function(result) {
				console.log("=== success ===");
				console.log(result);
			},
			error : function(result) {
				console.log("=== error ===");
				console.log(result);
			}
		});
	</script>
</body>
</html>