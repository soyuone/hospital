<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>练习页面</title>
	<style type="text/css">
		h1{
			color: red;
		}
		p{
			color: green;
			text-decoration: underline;
			text-indent: 2em;
			line-height: 1.5em;
		}
		span{
			color: yellow;font-weight: bold;font-style: italic;
		}
		blockquote{
			color: pink;
			font-size: 25px;
		}
		ul{
			color: green;
		}
		ol{
			color: green;
		}
		table,th,td,tr{
			border:1px solid #000;
			color: red;
		}
		.food>li{
			border:1px solid red;
		}
		.origin li{
			border:2px solid red;
		}
		*{
			font-size:20px;
		}
		a:hover{
		    color:black;
		    font-size:35px;
		}
		body{
			font-family: "Microsoft Yahei";font-size: 12px;color: #666;font-style: italic;
			text-align: left;
		}
	</style>
</head>
<body>
    <h1>了不起的盖茨比</h1>
    
    <p>1922年的春天，一个想要成名名叫<em>尼克•卡拉威</em>（<a href="http://www.imooc.com" target="_blank" title="托比•马奎尔Tobey Maguire">托比•马奎尔Tobey Maguire</a> 饰）的作家，离开了美国中西部，来到了纽约。<a>那是一个道德感渐失，爵士乐流行，走私为王，股票飞涨的时代。</a>为了追寻他的<span>美国梦</span>，他搬入纽约附近一海湾居住。</p>
    <p>菲茨杰拉德，二十世纪美国文学巨擘之一，兼具作家和编剧双重身份。他以诗人的敏感和戏剧家的想象为<strong>"爵士乐时代"</strong>吟唱华丽挽歌，其诗人和梦想家的气质亦为那个奢靡年代的不二注解。</p>
    <p>引用文本<q>庄生晓梦迷蝴蝶。望帝春心托杜鹃。</q></p>
    
    <hr/>
    <blockquote>明月出天山，苍茫云海间。&nbsp;&nbsp;长风几万里，吹度玉门关。<br/>汉下白登道，胡窥青海湾。&nbsp;&nbsp;由来征战地，不见有人还。</blockquote>
    <hr/>
    <p><strong>公司地址：<address>北京市西城区德外大街10号,本文的作者：<a href="mailto:lilian@imooc.com">Tom</a></address></strong></p>
    
	<ul>
		<li>精彩少年</li>
		<li>美丽突然出现</li>
		<li>触动心灵的旋律</li>
	</ul>
	
	<ol>
		<li>前端开发面试心法 </li>
		<li>零基础学习html</li>
		<li>JavaScript全攻略</li>
	</ol>
	
	<div id="hotList">
	   <h2>热门课程排行榜</h2>
	    <ol>
		    <li>前端开发面试心法 </li>
		    <li>零基础学习html</li>
		    <li>javascript全攻略</li>
	    </ol>
	</div>
	<div id="learningInstructed">
	    <h2>web前端开发导学课程</h2>
	    <ul>
		    <li>网页专业名词大扫盲 </li>
		    <li>网站职位定位指南</li>
		    <li>为您解密Yahoo网站制作流程</li>
	    </ul>
	</div>
	
	<hr/>
	<table>
	  <tbody>
	   	<caption>库存记录</caption>
	    <tr>
		    <th>班级</th>
		    <th>学生数</th>
		    <th>平均成绩</th>
	    </tr>
	    <tr>
		    <td>一班</td>
		    <td>30</td>
		    <td>89</td>
	    </tr>
	    <tr>
		    <td>二班</td>
		    <td>35</td>
		    <td>85</td>
	    </tr>
	    <tr>
		    <td>三班</td>
		    <td>32</td>
		    <td>80</td>
	    </tr>
	  </tbody>
	</table>
	
	<img src="http://img.mukewang.com/52da54ed0001ecfa04120172.jpg" title="电影介绍"> 
	<br/><br/>
	<form  method="post" action="">
	  	  账户: 
		<input type="text" name="myName" placeholder="请输入登录名">
		<br/>
		密码: 
	    <input type="password" name="pass" placeholder="请输入密码">
	    <br/><br/>
	    <textarea rows="3" cols="30">在这里输入内容...</textarea>
	    <br/>
	    <label>性别:</label>
	    <label>男</label>
	    <input type="radio" value="1"  name="gender" />
	    <label>女</label>
	    <input type="radio" value="2"  name="gender" checked="checked"/>
	    <br/>
	    <label>爱好:</label>
	    <select>
	      <option value="看书">看书</option>
	      <option value="旅游" selected="selected">旅游</option>
	      <option value="运动">运动</option>
	      <option value="购物">购物</option>
	    </select>
	    <br/><br/><br/>
        <label>爱好:</label>
	    <select multiple="multiple" id="select2">
	      <option value="看书">看书</option>
	      <option value="旅游">旅游</option>
	      <option value="运动">运动</option>
	      <option value="购物">购物</option>
	    </select>
	    <br/><br/>
	    <input type="submit" value="提交" name="submitBtn" />
	    <input type="reset" value="重置"/>
	    <br/>
	    <ul class="food">
		    <li>水果
		        <ul>
		        	<li>香蕉</li>
		            <li>苹果</li>
		            <li>梨</li>
		        </ul>
		    </li>
		    <li>蔬菜
		    	<ul>
		        	<li>白菜</li>
		            <li>油菜</li>
		            <li>卷心菜</li>
		        </ul>
		    </li>
		</ul>
	</form>
	<ul class="origin">
	    <li>水果
	        <ul>
	        	<li>香蕉</li>
	            <li>苹果</li>
	            <li>梨</li>
	        </ul>
	    </li>
	    <li>蔬菜
	    	<ul>
	        	<li>白菜</li>
	            <li>油菜</li>
	            <li>卷心菜</li>
	        </ul>
	    </li>
	</ul>
	<div id="div1" style="float: left;border:2px red solid;height:200px;width:200px;">浮动模型栏目一</div>
	<div id="div2" style="float: right;border:2px red solid;height:200px;width:200px;">浮动模型栏目二</div>
	<div id="div1" style="position:absolute;border:2px black solid;height:200px;width:200px;left: 500px;top: 2200px;">层模型栏目一</div>
	<div id="div1" style="position:relative;border:2px black solid;height:200px;width:200px;left: 300px;">层模型栏目二</div>	
</body>
</html>