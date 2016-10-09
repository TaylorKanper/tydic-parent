<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="bjui-pageContent">
    <form action="<%=request.getContextPath()%>/article/addInfo.do" data-toggle="validate" data-reload-navtab="true">
        <input type="hidden" name="id" value="${articleInfo.id}">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">名称：</label>
                            <input type="text" name="title" value="${info.name}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">内容：</label>
                            <div style="display: inline-block; vertical-align: middle;">
                                <textarea name="content" style="width:784px;height:50px" data-toggle="kindeditor">${info.value }</textarea>
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
