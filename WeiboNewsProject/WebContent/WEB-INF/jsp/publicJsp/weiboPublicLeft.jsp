<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<div id="left">
    <div id="navigation">
        <div id="top_nvg">
            <div id="logo">
                <a href="../weibo/weiboMain.action"><img src="../public/images/logo.png" width="62%"/></a>
                <p>YUNSHAN</p>
            </div>
        </div>
        <div id="mid_nvg">
            <div id="weibo_img">
                <img src="../public/images/weibologo.png" width="62%">
            </div>
            <div id="weibo_name">微博平台分析</div>
        </div>
        <div><a href="../event/index.action">首页</a></div>
        <div id="bot_nvg">
            <ul id="page">
                <li class="item"><a  href="../weibo/weiboNews.action?eid=${eid }">
                    <div class="item_img"></div>
                    <div class="item_name">微博新闻</div>
                </a></li>
                <li class="item"><a  href="../weibo/weiboTransform.action?eid=${eid }">
                    <div class="item_img"></div>
                    <div class="item_name">微博传播链</div>
                </a></li>
                <li class="item"><a href="../weibo/weiboCharacter.action?eid=${eid }">
                    <div class="item_img"></div>
                    <div class="item_name">读者基本属性</div>
                </a></li>
                <li class="item"><a  href="../weibo/showLocation.action?eid=${eid }">
                    <div class="item_img"></div>
                    <div class="item_name">读者地域分布</div>
                </a></li>
                <li class="item"><a  href="../weibo/weiboTopic.action?eid=${eid }">
                    <div class="item_img"></div>
                    <div class="item_name">评论话题挖掘</div>
                </a></li>
            </ul>
        </div>
    </div>
    <script src="../public/javascript/navigation.js"></script>
    <div id="edge">
        <img src="../public/images/首页_02.png"/>
    </div>
</div>
</html>