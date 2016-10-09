<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="{:U(ACTION_NAME)}" method="post">
        <input type="hidden" name="pageSize" value="{$Think.session.pageSize}">
        <input type="hidden" name="pageCurrent" value="{$Think.session.pageCurrent}">
        <input type="hidden" name="orderField" value="{$Think.session.orderField}">
        <input type="hidden" name="orderDirection" value="{$Think.session.orderDirection}">
        <div class="bjui-searchBar">
            <label>标题：</label><input type="text" name="search[subject]" value="${search.subject}" class="form-control" size="10" />
            <label>内容：</label><input type="text" name="search[presenter]" value="${search.presenter}" class="form-control" size="10" />
            <input type="hidden" name="search[type]" value="<php>echo $search['type'] ? $search['type'] : I('get.type')</php>">
            <button type="submit" class="btn-default" data-icon="search">查询</button>
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
                <div class="btn-group">
                    <button type="button" class="btn-default dropdown-toggle" data-toggle="dropdown" data-icon="copy">功能操作<span class="caret"></span></button>
                    <ul class="dropdown-menu right" role="menu">
                    <li><a href="<%=request.getContextPath()%>/article/add.do" data-toggle="dialog" data-width="1000" data-height="600" data-id="dialog-mask" data-mask="true"><i class="fa fa-plus"></i> 新增数据</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent">
    <table data-toggle="tablefixed" data-width="100%" data-nowrap="true">
    	<thead>
    	<tr>
    		<th>代码</th>
    		<th>名称</th>
    		<th>内容</th>
    		<th>发布人</th>
    		<th>发布时间</th>
    		<th>操作</th>
    	</tr>
    	</thead>
    	<tbody>
    	<c:forEach var="list" items="${list}">
    	<tr>
    		<td>${list.code}${jdbc_url}</td>
    		<td>${list.name}</td>
    		<td>${list.value}</td>
    		<td>${list.cuid}</td>
    		<td>${list.ctime}</td>
    		<td>
    			<a href="<%=request.getContextPath()%>/Config/edit.do?id=${list.id}" class="btn btn-default" data-toggle="dialog" data-width="1000" data-height="600" data-id="dialog-mask" data-mask="true">编辑</a>
    			<a href="<%=request.getContextPath()%>/Config/delete.do?id=${list.id}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
    		</td>
    	</tr>
    	</c:forEach>
    	</tbody>
    </table>
</div>

<%@ include file="/CommonPage/Common/pageFooter.jsp" %>
