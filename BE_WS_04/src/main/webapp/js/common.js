const logout = (url) => {
    $("#logout").click(function(e){
        console.log(url);
        $.ajax({
            url : url+"/login", // 서버주소(요청주소)
            type: "get" , //요청방식 (get | post | put | delete )
            dataType : "json",  //서버가 응답할때 전달하는 데이터 타입 (text | html | xml | json)
            //data :  //서버에게 전달하는 parameter정보s
            success : function(data , status ){//응답결과가 성공했을때 함수
                alert("로그아웃 되었습니다.")
                window.location.href="index.jsp";
            },
            error : function(err, status){//응답결과가 실패했을때 함수
                // 에러발생....
                alert(err +"발생했습니다. status = " + status);
            }
        });
        /////////////////////////////////////////////////////////
        e.preventDefault(); //return false;
    });
}

const bannerMove = (url) => {
    let bannerIndex=0;
    let bannerList=[];

    //ajax 요청한다.//////////////////////////////////////////////////////////
    $.ajax({ // 브라우져가 내장하고 있는 XMLHttpRequest
        url : url+"/banners", // 서버주소(요청주소)
        type: "post" , //요청방식 (get | post | put | delete )
        dataType : "json",  //서버가 응답할때 전달하는 데이터 타입 (text | html | xml | json)
        //data : , //서버에게 전달하는 parameter정보
        success : function(result , status ){//응답결과가 성공했을때 함수
            //alert(result.banners);

            bannerList = result.banners;
            $("#banner").html ( bannerList[bannerIndex++]);

            // 주기적으로 banner 변경
            setInterval(function(){
                $("#banner").html( bannerList[bannerIndex++]);
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
}
