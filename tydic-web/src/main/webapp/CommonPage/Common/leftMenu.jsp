<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="bjui-leftside">
    <div id="bjui-sidebar-s">
        <div class="collapse"></div>
    </div>
    <div id="bjui-sidebar">
        <div class="toggleCollapse"><h2><i class="fa fa-bars"></i> 导航栏 <i class="fa fa-bars"></i></h2><a href="javascript:;" class="lock"><i class="fa fa-lock"></i></a></div>
        <div class="panel-group panel-main" data-toggle="accordion" id="bjui-accordionmenu" data-heightbox="#bjui-sidebar" data-offsety="26">

            <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse0" class="active"><i class="fa fa-caret-square-o-down"></i>&nbsp;个人办公</a></h4>
                </div>
                <div id="bjui-collapse0" class="panel-collapse panelContent collapse in">
                    <div class="panel-body" >
                        <ul id="bjui-tree0" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        	<li data-id="passRead" data-pid="0">传阅管理</li>
                        	<li data-id="passRead_0" data-pid="passRead" data-url="<%=request.getContextPath()%>/article/index" data-tabid="passRead_0" data-fresh="true" data-reloadWarn="true">收到传阅</li>
                            <li data-id="passRead_1" data-pid="passRead" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="passRead_1" data-fresh="true" data-reloadWarn="true">发送传阅</li>
                            <li data-id="flow" data-pid="0">流程管理</li>
                        	<li data-id="flow_0" data-pid="flow" data-url="<%=request.getContextPath()%>/article/index.do" data-tabid="flow_0" data-fresh="true" data-reloadWarn="true">待办流程</li>
                            <li data-id="flow_1" data-pid="flow" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="flow_1" data-fresh="true" data-reloadWarn="true">发起流程</li>
                            <li data-id="flow_2" data-pid="flow" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="flow_2" data-fresh="true" data-reloadWarn="true">所有流程</li>
                        </ul>
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>
            
            <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse1" class=""><i class="fa fa-caret-square-o-right"></i>&nbsp;综合行政</a></h4>
                </div>
                <div id="bjui-collapse1" class="panel-collapse panelContent collapse">
                    <div class="panel-body" >
                        <ul id="bjui-tree1" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        	<li data-id="meeting" data-pid="0">会议管理</li>
                        	<li data-id="meeting_0" data-pid="meeting" data-url="<%=request.getContextPath()%>/article/index.do" data-tabid="meeting_0" data-fresh="true" data-reloadWarn="true">会议室申请</li>
                            <li data-id="meeting_1" data-pid="meeting" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="meeting_1" data-fresh="true" data-reloadWarn="true">会议室一览</li>
                            <li data-id="car" data-pid="0">车辆管理</li>
                        	<li data-id="car_0" data-pid="car" data-url="<%=request.getContextPath()%>/article/index.do" data-tabid="car_0" data-fresh="true" data-reloadWarn="true">用车申请</li>
                            <li data-id="car_1" data-pid="car" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="car_1" data-fresh="true" data-reloadWarn="true">车辆信息</li>
                            <li data-id="doc" data-pid="0">文档管理</li>
                        	<li data-id="doc_0" data-pid="doc" data-url="<%=request.getContextPath()%>/article/index.do" data-tabid="doc_0" data-fresh="true" data-reloadWarn="true">文档管理</li>
                            <li data-id="doc_1" data-pid="doc" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="doc_1" data-fresh="true" data-reloadWarn="true">文档类别</li>
                        	<li data-id="other" data-pid="0">其它功能</li>
                            <li data-id="other_0" data-pid="other" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="other_0" data-fresh="true" data-reloadWarn="true">通讯录</li>
                        	<li data-id="other_1" data-pid="other" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="other_1" data-fresh="true" data-reloadWarn="true">短信群发</li>
                        </ul>
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>
                        
            <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse2" class=""><i class="fa fa-caret-square-o-right"></i>&nbsp;人力资源</a></h4>
                </div>
                <div id="bjui-collapse2" class="panel-collapse panelContent collapse">
                    <div class="panel-body" >
                        <ul id="bjui-tree2" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        	<li data-id="user" data-pid="0">组织机构</li>
                            <li data-id="user_0" data-pid="user" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="user_0" data-fresh="true" data-reloadWarn="true">部门信息</li>
                            <li data-id="user_1" data-pid="user" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="user_1" data-fresh="true" data-reloadWarn="true">岗位信息</li>
                        	<li data-id="archives" data-pid="0">人事档案</li>
                            <li data-id="archives_0" data-pid="archives" data-url="<%=request.getContextPath()%>/Config/index.do" data-tabid="archives_0" data-fresh="true" data-reloadWarn="true">人事合同</li>
                            <li data-id="archives_1" data-pid="archives" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="archives_1" data-fresh="true" data-reloadWarn="true">变更信息</li>
                        	<li data-id="archives_2" data-pid="archives" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="archives_2" data-fresh="true" data-reloadWarn="true">离职信息</li>
                        	<li data-id="archives_3" data-pid="archives" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="archives_3" data-fresh="true" data-reloadWarn="true">奖惩记录</li>
                        	<li data-id="recruitment" data-pid="0">招聘管理</li>
                            <li data-id="recruitment_0" data-pid="recruitment" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="recruitment_0" data-fresh="true" data-reloadWarn="true">招聘需求</li>
                        	<li data-id="recruitment_1" data-pid="recruitment" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="recruitment_1" data-fresh="true" data-reloadWarn="true">招聘计划</li>
                        	<li data-id="recruitment_2" data-pid="recruitment" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="recruitment_2" data-fresh="true" data-reloadWarn="true">简历库</li>
                        	<li data-id="recruitment_3" data-pid="recruitment" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="recruitment_3" data-fresh="true" data-reloadWarn="true">面试记录</li>
                        	<li data-id="recruitment_4" data-pid="recruitment" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="recruitment_4" data-fresh="true" data-reloadWarn="true">OFFER记录</li>
                        	<li data-id="recruitment_5" data-pid="recruitment" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="recruitment_5" data-fresh="true" data-reloadWarn="true">后备资源库</li>
                        	<li data-id="training" data-pid="0">培训管理</li>
                            <li data-id="training_0" data-pid="training" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="training_0" data-fresh="true" data-reloadWarn="true">课程管理</li>
                        	<li data-id="training_1" data-pid="training" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="training_1" data-fresh="true" data-reloadWarn="true">培训机构</li>
                        	<li data-id="training_2" data-pid="training" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="training_2" data-fresh="true" data-reloadWarn="true">内部讲师</li>
                        	<li data-id="training_3" data-pid="training" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="training_3" data-fresh="true" data-reloadWarn="true">培训计划</li>
                        	<li data-id="training_4" data-pid="training" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="training_4" data-fresh="true" data-reloadWarn="true">培训实施</li>
                        </ul>
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>
            
            <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse3" class=""><i class="fa fa-caret-square-o-right"></i>&nbsp;信息发布</a></h4>
                </div>
                <div id="bjui-collapse3" class="panel-collapse panelContent collapse">
                    <div class="panel-body" >
                        <ul id="bjui-tree3" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        	<li data-id="notice" data-pid="0">通知公告</li>
                        	<li data-id="notice_0" data-pid="notice" data-url="<%=request.getContextPath()%>/article/index.do" data-tabid="notice_0" data-fresh="true" data-reloadWarn="true">通知公告</li>
                            <li data-id="notice_1" data-pid="notice" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="notice_1" data-fresh="true" data-reloadWarn="true">新增信息</li>
                            <li data-id="bbs" data-pid="0">内部论坛</li>
                            <li data-id="bbs_0" data-pid="bbs" data-url="<%=request.getContextPath()%>/article/index.do" data-tabid="bbs_0" data-fresh="true" data-reloadWarn="true">论坛首页</li>
                            <li data-id="bbs_1" data-pid="bbs" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="bbs_1" data-fresh="true" data-reloadWarn="true">版块管理</li>
                        	<li data-id="portal" data-pid="0">门户管理</li>
                            <li data-id="portal_0" data-pid="portal" data-url="<%=request.getContextPath()%>/article/index.do" data-tabid="portal_0" data-fresh="true" data-reloadWarn="true">文章列表</li>
                            <li data-id="portal_1" data-pid="portal" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="portal_1" data-fresh="true" data-reloadWarn="true">栏目管理</li>
                        </ul>
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>
            
            <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse4" class=""><i class="fa fa-caret-square-o-right"></i>&nbsp;系统管理</a></h4>
                </div>
                <div id="bjui-collapse4" class="panel-collapse panelContent collapse">
                    <div class="panel-body" >
                        <ul id="bjui-tree4" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        	<li data-id="user" data-pid="0">权限管理</li>
                            <li data-id="user_0" data-pid="user" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="user_0" data-fresh="true" data-reloadWarn="true">用户列表</li>
                            <li data-id="user_1" data-pid="user" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="user_1" data-fresh="true" data-reloadWarn="true">角色管理</li>
                        	<li data-id="user_2" data-pid="user" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="user_2" data-fresh="true" data-reloadWarn="true">节点管理</li>
                        	<li data-id="system" data-pid="0">系统设置</li>
                            <li data-id="system_0" data-pid="system" data-url="<%=request.getContextPath()%>/Config/index.do" data-tabid="system_0" data-fresh="true" data-reloadWarn="true">基础配置</li>
                        	<li data-id="system_2" data-pid="system" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="system_2" data-fresh="true" data-reloadWarn="true">导航管理</li>
                        </ul>
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>
            

        </div>
    </div>
</div>