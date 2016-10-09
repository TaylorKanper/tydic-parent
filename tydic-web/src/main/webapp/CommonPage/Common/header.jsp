<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--[if lte IE 7]>
    <div id="errorie"><div>您还在使用老掉牙的IE，正常使用系统前请升级您的浏览器到 IE8以上版本 <a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages">点击升级</a>&nbsp;&nbsp;强烈建议您更改换浏览器：<a href="http://down.tech.sina.com.cn/content/40975.html" target="_blank">谷歌 Chrome</a></div></div>
<![endif]-->
<header id="bjui-header">
    <div class="bjui-navbar-header">
        <button type="button" class="bjui-navbar-toggle btn-default" data-toggle="collapse" data-target="#bjui-navbar-collapse">
            <i class="fa fa-bars"></i>
        </button>
        <a class="bjui-navbar-logo" href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath()%>/Public/Img/logo.png"></a>
    </div>
    <nav id="bjui-navbar-collapse">
        <ul class="bjui-navbar-right">
            <li class="datetime"><div><span id="bjui-date"></span><br><i class="fa fa-clock-o"></i> <span id="bjui-clock"></span></div></li>
            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">切换系统 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="http://www.topstack.cn" target="_blank"><i class="fa fa-flag"></i> 门户网站</a></li>
                    <li class="divider"></li>
                    <li><a href="/ewsdOA"><i class="fa fa-flag"></i> OA系统</a></li>
                    <li class="divider"></li>
                    <li><a href="/ewsdOA"><i class="fa fa-flag"></i> CRM系统</a></li>
                    <li class="divider"></li>
                    <li><a href="/ewsdOA"><i class="fa fa-flag"></i> IMS系统</a></li>
                </ul>
            </li>
            <li><a href="#">消息 <span class="badge">4</span></a></li>
            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">我的账户 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="{:U('Admin/User/modifyPwd')}" data-toggle="dialog" data-id="changepwd_page" data-mask="true" data-width="400" data-height="260">&nbsp;<span class="fa fa-lock"></span> 修改密码</a></li>
                    <li><a href="{:U('Admin/UserDangjian/edit?uid='.getSession('myInfo.uid'))}" data-toggle="dialog" data-id="changepwd_page" data-mask="true" data-width="1000" data-height="600">&nbsp;<span class="fa fa-user"></span> 我的资料</a></li>
                    <!--li><a href="{:U('Admin/Index/cache')}" data-toggle="navtab">&nbsp;<span class="fa fa-trash"></span> 清理缓存</a></li-->
                    <li class="divider"></li>
                    <li><a href="{:U('Admin/Public/loginOut')}" class="red">&nbsp;<span class="fa fa-power-off"></span> 注销登陆</a></li>
                </ul>
            </li>
            <li class="dropdown"><a href="#" class="dropdown-toggle theme purple" data-toggle="dropdown"><i class="fa fa-tree"></i></a>
                <ul class="dropdown-menu" role="menu" id="bjui-themes">
                    <li><a href="javascript:;" class="theme_default" data-toggle="theme" data-theme="default">&nbsp;<i class="fa fa-tree"></i> 黑白分明&nbsp;&nbsp;</a></li>
                    <li><a href="javascript:;" class="theme_orange" data-toggle="theme" data-theme="orange">&nbsp;<i class="fa fa-tree"></i> 橘子红了</a></li>
                    <li class="active"><a href="javascript:;" class="theme_purple" data-toggle="theme" data-theme="purple">&nbsp;<i class="fa fa-tree"></i> 紫罗兰</a></li>
                    <li><a href="javascript:;" class="theme_blue" data-toggle="theme" data-theme="blue">&nbsp;<i class="fa fa-tree"></i> 青出于蓝</a></li>
                    <li><a href="javascript:;" class="theme_red" data-toggle="theme" data-theme="red">&nbsp;<i class="fa fa-tree"></i> 红红火火</a></li>
                    <li><a href="javascript:;" class="theme_green" data-toggle="theme" data-theme="green">&nbsp;<i class="fa fa-tree"></i> 绿草如茵</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</header>

<!--div id="bjui-hnav">
    <button type="button" class="bjui-hnav-toggle btn-default" data-toggle="collapse" data-target="#bjui-hnav-navbar">
        <i class="fa fa-bars"></i>
    </button>
    <ul id="bjui-hnav-navbar">
        <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-check-square-o"></i> 表单元素</a>
            <ul id="bjui-hnav-tree1" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true" data-noinit="true">
                <li data-id="1" data-pid="0">表单元素</li>
                <li data-id="10" data-pid="1" data-url="form-button.html" data-tabid="form-button">按钮</li>
                <li data-id="11" data-pid="1" data-url="form-input.html" data-tabid="form-input">文本框</li>
                <li data-id="12" data-pid="1" data-url="form-select.html" data-tabid="form-select">下拉选择框</li>
                <li data-id="13" data-pid="1" data-url="form-checkbox.html" data-tabid="table">复选、单选框</li>
                <li data-id="14" data-pid="1" data-url="form.html" data-tabid="form">表单综合演示</li>
            </ul>
        </li>
        <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-table"></i> 表格</a>
            <ul id="bjui-hnav-tree2" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true" data-noinit="true">
                <li data-id="2" data-pid="0">表格</li>
                <li data-id="20" data-pid="2" data-url="table.html" data-tabid="table">普通表格</li>
                <li data-id="21" data-pid="2" data-url="table-fixed.html" data-tabid="table-fixed">固定表头表格</li>
                <li data-id="22" data-pid="2" data-url="table-edit.html" data-tabid="table-edit">可编辑表格</li>
            </ul>
        </li>
        <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-plane"></i> 弹出窗口</a>
            <ul id="bjui-hnav-tree3" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true" data-noinit="true">
                <li data-id="3" data-pid="0">弹出窗口</li>
                <li data-id="30" data-pid="3" data-url="dialog.html" data-tabid="dialog">弹出窗口</li>
                <li data-id="31" data-pid="3" data-url="alert.html" data-tabid="alert">信息提示</li>
            </ul>
        </li>
        <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-image"></i> 图形报表</a>
            <ul id="bjui-hnav-tree4" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true" data-noinit="true">
                <li data-id="4" data-pid="0">图形报表</li>
                <li data-id="40" data-pid="4" data-url="highcharts.html" data-tabid="chart">Highcharts图表</li>
                <li data-id="40" data-pid="4" data-url="echarts.html" data-tabid="echarts">ECharts图表</li>
            </ul>
        </li>
        <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-coffee"></i> 框架组件</a>
            <ul id="bjui-hnav-tree5" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true" data-noinit="true">
                <li data-id="5" data-pid="0">框架组件</li>
                <li data-id="51" data-pid="5" data-url="tabs.html" data-tabid="tabs">选项卡</li>
            </ul>
        </li>
        <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-bug"></i> 其他插件</a>
            <ul id="bjui-hnav-tree6" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true" data-noinit="true">
                <li data-id="6" data-pid="0">其他插件</li>
                <li data-id="61" data-pid="6" data-url="ztree.html" data-tabid="ztree">zTree</li>
                <li data-id="62" data-pid="6" data-url="ztree-select.html" data-tabid="ztree-select">zTree下拉选择</li>
            </ul>
        </li>
        <li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-database"></i> 综合应用</a>
            <ul id="bjui-hnav-tree7" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true" data-noinit="true">
                <li data-id="8" data-pid="0">综合应用</li>
                <li data-id="80" data-pid="8" data-url="table-layout.html" data-tabid="table-layout">局部刷新1</li>
            </ul>
        </li>
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cog"></i> 系统设置 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="#">角色权限</a></li>
                <li><a href="#">用户列表</a></li>
                <li class="divider"></li>
                <li><a href="#">关于我们</a></li>
                <li class="divider"></li>
                <li><a href="#">友情链接</a></li>
            </ul>
        </li>
    </ul>
    <form class="hnav-form">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search...">
            <span class="input-group-btn">
                <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
            </span>
        </div>
    </form>
</div-->