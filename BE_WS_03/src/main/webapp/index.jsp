<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>IT's KB</title>
  <link rel="stylesheet" type="text/css" href="css/common.css">
  <link rel="stylesheet" type="text/css" href="css/navbar.css">
  <link rel="stylesheet" type="text/css" href="css/footer.css">

  <!-- index.html 에만 적용할 CSS -->
  <style type="text/css">
    /*
      #main에
      1)  flex 적용
      2)  justify-content속성을 space-between 적용
      3)  margin-top 을 5px설정
    */
    #main{
      display: flex;
      justify-content: space-between;
      margin-top: 5px;

    }

    /*
       #main .main-item에
       1) 가로길이 33% 설정
    */
    #main .main-item{
      width:33%;
    }

    /*
      #main .main-item img에
      1)가로길이를 100%설정
    */
    #main .main-item img{
      width: 100%;
    }

    /*
      #main .main-item button 에
      1)float속성을 오른쪽
      2) 상하좌우 패팅 5px
      3) 가로길이 5px
      4) 글자크기 15px
    */
    #main .main-item button{
      float: right;
      padding:5px;
      width:80px;
      font-size:15px;
    }
  </style>

  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script type="text/javascript">


    ////////////////////////////////////////////////////////////////////////
    $(function(){
      let bannerIndex=0;
      let bannerList=[];

      //ajax 요청한다.//////////////////////////////////////////////////////////
      $.ajax({ // 브라우져가 내장하고 있는 XMLHttpRequest
        url : "${pageContext.request.contextPath}/banner", // 서버주소(요청주소)
        type: "post" , //요청방식 (get | post | put | delete )
        dataType : "json",  //서버가 응답할때 전달하는 데이터 타입 (text | html | xml | json)
        //data : , //서버에게 전달하는 parameter정보
        success : function(result , status ){//응답결과가 성공했을때 함수
          //alert(result.banners);

          bannerList = result.banners;
          $("#banner").html ( bannerList[bannerIndex++].bannerText);

          // 주기적으로 banner 변경
          setInterval(function(){
            $("#banner").html( bannerList[bannerIndex++].bannerText);
            if(bannerIndex==bannerList.length ){
              bannerIndex=0;
            }
          } , 2000);

        },
        error : function(err, status){//응답결과가 실패했을때 함수
          // 에러발생....
          alert(err +"발생했습니다. status = " + status);
        }
      });
      //////////////////////////////////////////////////////////////////////


      ////////////////////////////////////////
      $(".main-item-btn").click(function(){
        let id = $(this).closest(".main-item").attr('data-main-item-id');
        alert(id)
      })

    });//ready끝

  </script>

</head>
<body>
<div id="container">

  <nav id="navbar">
    <!-- 5개의 메뉴생성 -->
    <ul>
      <li class="nav-item logo"><img src="images/logo.jpg" alt="로고입니다." ></li>
      <li class="nav-item"> <a href="personal.html">개인</a></li>
      <li class="nav-item"><a href="busines.html">기업</a></li>
      <li class="nav-item"><a href="login.html">로그인</a></li>
      <li class="nav-item"><a href="register.html">회원가입</a></li>
    </ul>
  </nav>

  <div id="banner">지금 당신의 행복! IT's KB Life!</div>

  <div id="main" >

    <!-- 총 3개의 서브영역 -->
    <div class="main-item" data-main-item-id="10">
      <img src="https://picsum.photos/200" alt="">
      <h2>main-item 1</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <button class="main-item-btn">button 1</button>
    </div>

    <div class="main-item" data-main-item-id="20">
      <img src="https://picsum.photos/200" alt="">
      <h2>main-item 2</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <button class="main-item-btn">button 2</button>
    </div>



    <div class="main-item" data-main-item-id="30">
      <img src="https://picsum.photos/200" alt="">
      <h2>main-item 3</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
      <button class="main-item-btn">button 3</button>
    </div>

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