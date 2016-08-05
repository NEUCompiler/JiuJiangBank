<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
	<style type="text/css" media="all">@import "resource/css/master.css";</style>
	<script type="text/JavaScript" src="resource/js/jquery.js"></script>
<title>九江银行</title>

<script> 
		//显示菜单
		$(function(){
			var url = "<%=path%>/111/menuInfo.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
				},
				dataType: 'json', 
				success:function(data){ 
					var d=eval('('+data.jsonstr+')');
					var dd = d.data;
					var pos=0;
					var str="";
					for(var i = 0; i < dd.length; i++){
						if(dd[i].menuPar == -1){
							//var str=$("<p>"+dd[i].menuName+"</p>");
							pos=i;
							if(i != 0){
								str+="</div></div> </div> <div class=\"panel panel-default\"> <div class=\"panel-heading\">"+
									"<a class=\"panel-title\" data-toggle=\"collapse\" data-parent=\"#panel-780934\" href=\"#panel-element-"+pos+"\">"+dd[i].menuName+"</a> </div>"
									+"<div id=\"panel-element-"+pos+"\" class=\"panel-collapse collapse\"> <div class=\"panel-body\">";
							}
							else{
								str+="<div class=\"panel panel-default\"> <div class=\"panel-heading\">"+
									"<a class=\"panel-title\" data-toggle=\"collapse\" data-parent=\"#panel-780934\" href=\"#panel-element-"+pos+"\">"+dd[i].menuName+"</a> </div>"
									+"<div id=\"panel-element-"+pos+"\" class=\"panel-collapse collapse in\"> <div class=\"panel-body\">";
							}
						} else{
							str+="<a href=\""+dd[i].menuSrc+"\">&nbsp;&nbsp;&nbsp;&nbsp;-"+dd[i].menuName+"</a><br/>";
						}
						//$("#panel-780934").append(str); 
					}
					str+="</div> </div> </div><br/>";
					$("#panel-780934").append(str);
				}, 
				error:function(a,b,c,d){
					alert(a);
					alert(b);
					alert(c);
					alert(d);
				} 
			});
		}); 
		
	</script> 

</head>
<body>
	<div class="container">
		<!--手风琴切换， 缩略图-->
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-2 column">
						<div class="panel-group" id="panel-780934"></div>
					</div>
					<div class="col-md-10 column">
						<div class="row">
							<div class="col-md-4">
								<div class="thumbnail">
									<img alt="300x200" src="<%=basePath%>image/default4.jpg" />
									<div class="caption">
										<h3>新版网站上线</h3>
										<p>
											九江银行全新手机银行3.0，更丰富的移动金融服务、更智慧的操作体验、更完善的安全保护，结合全新设计的用户界面，邀您“智惠”体验移动金融新生活。
										</p>
										<p>
											<a class="btn" href="#">点击了解</a>
										</p>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="thumbnail">
									<img alt="300x200" src="<%=basePath%>image/default5.jpg" />
									<div class="caption">
										<h3>个人非柜台业务</h3>
										<p>
											为进一步贯彻落实普惠民生、服务百姓、让利于民的精神，为客户提供更加优质、优惠、便捷、高效服务，从即日起，九江银行隆重推出个人非柜台结算业务“免费银行”。
										</p>
										<p>
											<a class="btn" href="#">点击了解</a>
										</p>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="thumbnail">
									<img alt="300x200" src="<%=basePath%>image/default6.jpg" />
									<div class="caption">
										<h3>暂停服务公告</h3>
										<p>
											为提升我行核心系统稳定运行能力，兹定于2016年8月13日(星期六)23:00至14日12:00期间开展核心系统升级工作，届时我行将暂停所有对外业务服务。
										</p>
										<p>
											<a class="btn" href="#">点击了解</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="progress"></div>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="col-md-1"></div>
				<div class="col-md-3">
					<a href="#">网站地图</a>
				</div>
				<div class="col-md-3">
					<a href="#">关于我们</a>
				</div>
				<div class="col-md-3">
					<a href="#">联系我们</a>
				</div>
				<div class="col-md-2">
					<a href="#">常见问题</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
