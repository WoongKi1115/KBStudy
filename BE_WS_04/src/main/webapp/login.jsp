<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2023-08-18
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IT's KB - login</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/navbar.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">

    <!-- login.html 문서에 적용할  CSS -->
    <style type="text/css">
        /*
          #login에
          1) 상하 20px, 좌우 0 패딩설정
        */
        #login{
            padding:20px 0;
        }

        /*
          #login h1에
          1) 상하좌우여백 5px
          2) 글자 가운데 정렬
        */
        #login h1{
            padding: 5px;
            text-align: center;;
        }

        /*
         #login form에
         1) 높이 200px설정
         2) border 속성을 1px solid gray 설정
         3) 상하좌우패딩 40px
       */

        #login form{
            height: 200px;
            border: 1px solid gray;
            padding: 40px;
        }

        /*
           #login .form-item에
           1) margin-bottom을 10px설정
        */
        #login .form-item{
            margin-bottom: 10px;
        }

        /*
          #login .form-item label에
          1) display속성을 inline-block 으로 설정
          2) 가로길이를 100px설정
          3) 글자크기 18px설정
        */
        #login .form-item label{
            display: inline-block;
            width: 100px;
            font-size: 18px;
        }

        /*
          #login .form-item input 에
          1) display속성을 inline-block 으로 설정
          2) 가로길이를 200px설정
          3) 글자크기 18px설정
        */
        #login .form-item input{
            display: inline-block;
            width: 200px;
            font-size: 18px;
        }

        /*
          #login button 에
          1) float속성을 오른쪽
          2) 가로길이를 80px설정
          3) 글자크기 18px설정
          4) 상하좌우 패딩을 5px
          5) margin-top을 10px
        */
        #login button{
            float: right;
            width: 80px;
            font-size: 18px;
            padding: 5px;
            margin-top: 10px;
        }

    </style>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script type="text/javascript">
        /*
        -WS_04_jQuery 로 변경
         아래의 javaScript기반 코드를  jQuery기반으로 코드로 변경하세요.

         추가 :
             모든 정보가 일치하면
             Back End 에 대한 요청과 결과를 대신하여 제공되는 response.json 를 요청하고 , 결과
             를 받아서 alert() 으로 보여준다.json 의 결과값은 제공된 json 파일을 확인한다
         */

        $(function(){
            $("#btnLogin").click(function(e){
                let email = $("#email") ; //document.getElementById("email")
                let pwd = $("#password");//document.getElementById("password")

                if(email.val()==""){
                    alert("이메일를 입력해주세요.");
                    email.focus();
                    return false;
                }

                if(pwd.val()==""){
                    alert("비밀번호를 입력해주세요.");
                    pwd.focus();
                    return false;
                }
                //////////////////////////////////////////////////////////////
                //alert("모든정보가 있습니다.")
                $.ajax({
                    url : "${pageContext.request.contextPath}/login", // 서버주소(요청주소)
                    type: "post" , //요청방식 (get | post | put | delete )
                    dataType : "json",  //서버가 응답할때 전달하는 데이터 타입 (text | html | xml | json)
                    data : {
                        email: email.val(),
                        password: pwd.val()
                    }, //서버에게 전달하는 parameter정보s
                    success : function(data , status ){//응답결과가 성공했을때 함수

                        if(data.result=="success"){
                            alert("로그인되었습니다.")
                            location.href="index.jsp";
                            console.log(data.result)
                        }else{
                            console.log(data.result)
                            alert("로그인실패하였습니다.")
                        }
                    },
                    error : function(err, status){//응답결과가 실패했을때 함수
                        // 에러발생....
                        alert(err +"발생했습니다. status = " + status);
                    }
                });
                /////////////////////////////////////////////////////////
                e.preventDefault(); //return false;

            });

        });//readyEnd


    </script>
</head>
<body>
<div id="container">
    <jsp:include page="navBar.jsp"/>

    <div id="banner">지금 당신의 행복! IT's KB Life!</div>

    <div id="login">
        <h1>Login</h1>
        <form action="" method="post">
            <div class="form-item">
                <label for="email">이메일</label>
                <input type="text" id="email" name="email">
            </div>

            <div class="form-item">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password">
            </div>

            <hr>
            <button id="btnLogin">로그인</button>
        </form>
    </div>

    <footer>
        <ul>
            <li>서울시 선릉역 We-Work</li>
            <li>02-0000-0000</li>
        </ul>
    </footer>


</div>
</body>
</html>
