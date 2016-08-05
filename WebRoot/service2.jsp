<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset= utf-8"  />
	<title>Service</title>
	<style type="text/css" media="all">@import "resource/css/master.css";</style>
</head>
<body>
    <div class="service1main">
    	<div class="service1maintop">
        	<img src="resource/images/QQ图片20160724212526.jpg" class="service1maintopimg"/>
        	<p><font color="#0000FF" style="font-weight:bold">网上银行</font></p>
        </div>
        
        <div class="service1mainbottom">
        	<p class="service1mainbottomtitle" align="center">服务功能</p>
        <div class="service1mainbottomcontent">
        	<p><font style="font-weight:bold" color="#6633FF">1. 我的账户</font></p>
            <p>服务功能为：我的网银，账户查询，追加新账户，虚拟卡，VIP对账单，个性化设置， E家亲账户，其他账户服务，功能介绍。</p>
<p>“我的账户”为您提供了丰富的账户查询和管理功能，您可以查询活期、定期、公积金、支票通、履约保函等账户信息，核对VIP对账单，对您的账户进行个性化设置，追加新的网上银行账户，实现网上银行与手机银行、电话银行等的互动，挂失账户等等。足不出户，账户维护尽在指掌中。</p>
		<p>（1）E家亲账户</p>
        <p>客户通过网上银行可将本人名下的账户，授权给他人进行账户余额及明细查询，也可以接受他人的授权，查看他人的账户信息。</p>
        <p>（2）虚拟卡</p>
        <p>我行针对网上购物支付业务推出的一项安全支付工具，只有卡号，没有实体卡，通过网上银行开立，只能进行规定金额内的网上购物支付，不能进行转账、汇款，保证资金的相对封闭流转。</p>
<p><font style="font-weight:bold" color="#6633FF">2. 转账汇款</font></p>
	  <p>服务功能为：活期转账汇款，定活互转，向企业转账，跨行转账，预约转账，批量转账，外汇汇款，结果查询，收款人名册，功能介绍。</p>
      <p>“转账汇款”使您能够实现多种账户之间的转账汇款；收款人既可以是建设银行个人客户，也可以是建设银行企业客户，还可以是其他商业银行的个人客户，您还可以进行全球汇出汇款。为了省去您多次输入同一账号的麻烦，我们还为您准备了方便易用的收款人名册。</p>
		<p><font style="font-weight:bold" color="#6633FF">3. 缴费支付</font></p>  
		<p>服务功能为：缴费支付，批量缴费，预约缴费，缴费支付记录查询，E付通，银行卡网上小额支付，功能介绍。</p>
        <p>“缴费支付”为您提供全方位的缴费服务，包括缴纳手机费、电话费、水费、电费等各种日常生活费用，并且可以批量缴纳、预约缴纳，免去您的奔波之苦。新推出的银行卡网上小额支付功能让您的银行卡即便不开通网上银行，也能进行网上支付。</p>
        
        <p><font style="font-weight:bold" color="#6633FF">4. 信用卡</font></p>  
		<p>服务功能为：信用卡开卡，信用卡查询，信用卡还款，购汇还款，信用卡管理，3DS管理，功能介绍。</p>
        <p>“信用卡”为您提供：在线开通信用卡，查询信用额度、取款额度、可用额度、余额、消费积分等，还可以给您的信用卡还款、挂失信用卡、验证3DS支付密码等。</p>
        
        <p><font style="font-weight:bold" color="#6633FF">5. 个人贷款</font></p>  
		<p>服务功能为：我的贷款，归还贷款，贷款维护，贷款试算，功能介绍。</p>
        <p>“个人贷款”为您提供贷款基本信息、账户明细、还款计划等基本查询；支持您在线还款、更新账户及个人基本信息。尤其我们还为您提供了贷款试算服务，方便您精打细算，帮您用最实惠的办法还款。</p>
        
        <p><font style="font-weight:bold" color="#6633FF">6. 投资理财</font></p>  
		<p>服务功能为：基金业务，外汇买卖，黄金业务，债券业务，保险业务，银证业务，银行存管，证券管理，理财产品，银期直通车，功能介绍等。</p>
        <p>在这里您可以随时分析、投资基金、外汇、黄金、债券、保险、期货等，进行全方位的理财。我们还为您提供了银证转账、银行存管等辅助服务，让您能够全天候、随时随地地享受到专家型的理财服务。</p>
        
        <p><font style="font-weight:bold" color="#6633FF">7. 客户服务</font></p>  
		<p>服务功能为：用户名设置，日志查询，个人资料修改，网页定制，邮件服务，定制快速通道，网银积分查询，功能介绍。</p>
        <p>在这里您可以设置您登录网银的用户名、查询交易记录、修改个人资料、定制个性化网页、给我们发送电子邮件、定制快速链接等，方便又快捷。</p>
        
        <p><font style="font-weight:bold" color="#6633FF">8. 安全中心</font></p>  
		<p>服务功能为：修改密码，动态口令，账号保护，短信服务，安全设置，软件下载，功能介绍。</p>
        <p>“安全中心”为您提供密码维护、动态口令卡登记和管理、账户部分号码屏蔽、短信查询和安全提醒、网银安全定制等服务。</p>

			</div>
            <div class="service2last">
        	<p>最近更新时间：2016年7月18日</p>
        	</div>
        </div>
    </div>
	

</body>
</html>
