<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="bjui-pageContent">
    <form action="<%=request.getContextPath()%>/user/update.do" data-toggle="validate" data-reload-navtab="true">
        <input type="hidden" name="id" value="${articleInfo.id}">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">用户名：</label>
                            <input type="text" name="username" value="${info.username}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">姓名：</label>
                            <div style="display: inline-block; vertical-align: middle;">
                                <textarea name="name" style="width:784px;height:50px" data-toggle="kindeditor">${info.name }</textarea>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>

<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
    </ul>
</div>