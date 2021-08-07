<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>会员注册界面</title>
<%--    静态包含 base标签、css样式、jQuery--%>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#username").blur(function () {
            //    1.获取用户名
                let value = this.value;
                $.getJSON("http://localhost:8080/book/userServlet","action=ajaxExistsUsername&username=" + value,function (data) {
                    if (data.existsUsername){
                        $(".errorMsg").text("用户名已存在！");
                    }else {
                        $(".errorMsg").text("用户名可用！");
                    }
                });
            });
            //给验证码绑定单击事件
            $("#code_img").click(function () {
                // alert("213");
                //在事件响应的function函数中有一个this对象.这个this对象,是当前正在响应事件的dom对象
                //src属表示验证码img标签的图片路径.可读可写
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
                <%--this.src = "${basePath}kaptcha.jpg"--%>
            });
            // 1.验证用户名、密码、确认密码、email是否符合规定
            $("#sub_btn").click(function () {
                // 2.验证成功提交表单
                // 3.验证失败，交代为什么失败
                    //获取用户输入的所有值
                var username = $("#username").val();
                var password = $("#password").val();
                var repwd = $("#repwd").val();
                var email = $("#email").val();
                var code = $("#code").val();

                //正则表达式：定义正确规则的一个表达式
                // 使用：
                // 1.创建一个正则表达式
                // var reg = /a/;
                // 2.使用test()验证传入值是否符合规则
                // alert(reg.test("abc"));
                // alert(username + "-->"+password+"-->"+repwd+"-->"+email+"-->"+code);
                var regUserName = /^\w{5,12}$/;
                var regPassword = /^\w{5,12}$/;
                var regEmail = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //用户名：不能为空 6位以上 18以下 不能为为非法字符
                if (!regUserName.test(username)){
                    $(".errorMsg").text("用户名输入不合法！");
                    return false;
                }
                //密码：不能为空 6位以上 18以下 不能为为非法字符
                else if (!regPassword.test(password)){
                    $(".errorMsg").text("密码输入不合法!");
                    return false;
                }
                //确认密码：和密码相同
                else if (repwd != password){
                    $(".errorMsg").text("两次密码不一致!");
                    return false;
                }
                // email：xxxx@aa.com
                else if (!regEmail.test(email)){
                    $(".errorMsg").text("邮箱格式输入有误！");
                    return false;
                }
                //验证码：保证用户输入值不为空
                else if (code == ""){
                    $(".errorMsg").text("验证码输入有误！");
                    return false;
                }
                return true;

            });
        });
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.png" >
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册小明同学书城会员</h1>
                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
                               tabindex="1" name="username" id="username"
                               value="${requestScope.username}"/>
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
                               tabindex="1" name="password" id="password"/>
                        <br />
                        <br />
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
                               tabindex="1" name="repwd" id="repwd"/>
                        <br />
                        <br />
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
                               tabindex="1" name="email" id="email"
                               value="${requestScope.email}"/>
                        <br />
                        <br />
                        <label>&nbsp;&nbsp;&nbsp;验证码：</label>
                        <input class="itxt" name="code" type="text" style="width: 100px;"
                                id="code"/>
                        <img  id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width: 120px;height: 40px">
                        <br />
                        <br />
                        <input type="submit" value="注册" id="sub_btn" style="cursor: pointer"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>