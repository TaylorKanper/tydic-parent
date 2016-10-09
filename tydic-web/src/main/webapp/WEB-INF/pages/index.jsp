<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>天源迪科OA系统 - Powered By 康鹏</title>
    <meta name="Keywords" content="天源迪科OA系统 - Powered By 康鹏"/>
    <%@ include file="/CommonPage/Common/intoHead.jsp" %>
</head>

<body>
    <%@ include file="/CommonPage/Common/header.jsp" %>

    <div id="bjui-container" class="clearfix">
        <%@ include file="/CommonPage/Common/leftMenu.jsp" %>

        <div id="bjui-navtab" class="tabsPage">
            <div class="tabsPageHeader">
                <div class="tabsPageHeaderContent">
                    <ul class="navtab-tab nav nav-tabs">
                        <li data-url=""><a href="javascript:;"><span><i class="fa fa-home"></i> #maintab#</span></a></li>
                    </ul>
                </div>
                <div class="tabsLeft"><i class="fa fa-angle-double-left"></i></div>
                <div class="tabsRight"><i class="fa fa-angle-double-right"></i></div>
                <div class="tabsMore"><i class="fa fa-angle-double-down"></i></div>
            </div>
            <ul class="tabsMoreList">
                <li><a href="javascript:;">#maintab#</a></li>
            </ul>

            <div class="navtab-panel tabsPageContent">
                <div class="navtabPage unitBox">

                    <div class="bjui-pageHeader" style="background:#FFF;">
                        <div style="padding: 0 15px;">
                            <div class="row">
                            	<div class="col-md-4">
                                    <h5>项目GIT：<a href="https://github.com/tydic-kanper/tydic-parent" target="_blank">https://github.com/tydic-kanper/tydic-parent</a></h5>
                                </div>
                                <div class="col-md-4">
                                    <h5>技术博客：<a href="http://blog.csdn.net/kang82651204" target="_blank">http://blog.csdn.net/kang82651204</a></h5>
                                </div>
                                <div class="col-md-4">
                                    <h5>联系方式：kangpeng@tydic.com</h5>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <%@ include file="/CommonPage/Common/footer.jsp" %>
</body>
</html>