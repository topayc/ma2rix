/**
 * Created by on 2014-09-03.
 */


//ajax list append
function addRowType1() {
    $(".arrList").append(
            "<li class='secType1 oh'>" +
            "   <div class='coverArt'>" +
            "      <a href='#none'><img src='../../images/holderType3.gif' alt='' style='width: 110px; height: 110px;'></a>" +
            "   </div>" +
            "   <div class='soundArea'>" +
            "       <div class='soundHeader'>" +
            "          <a class='bulPlay' href='#none' data-sound-url='' data-sound-target=''><i class='fa fa-play-circle fa-2x'></i></a> " +
            "          <span class='songTitle'><a href='#none'>You raise up me</a></span> " +
            "          <span class='songSinger'><a href='#none'>ma2rix</a></span>" +
            "          <a class='btn small btnPoint ctgView' href='#none'><span>rock</span></a>" +
            "       </div>" +
            "       <div class='soundBody'>" +
            "          <div class='pajaImg'><img src='../../images/holderType2.gif' alt='' style='width: 100%;'></div>" +
            "          <div class='soundBar'></div>" +
            "       </div>" +
            "       <div class='soundFooter'>" +
            "          <a class='btn large btnType1' href='#none'><span>Fan</span></a> " +
            "          <a class='btn large btnType2' href='#none' data-showing='0'><span>Comment</span></a> " +
            "          <a class='btn large btnType3' href='#none'><span>연주자 현황</span></a> " +
            "          <a class='btn large btnPoint btnType4' href='#none'><span>참여하기</span></a> " +
            "          <a class='btn large btnType5' href='#none'><span>Play list</span></a> " +
            "          <a class='btn large btnType6' href='#none'><span>맵보기</span></a> " +
            "          <a class='btn large btnPoint btnType7' href='#none'><span>구매</span></a> " +
            "          <a class='btn large btnType8' href='#none'><span>악보</span></a> " +
            "          <a class='btn large btnType9' href='#none'><span>SponsorsShip</span></a> " +
            "          <a class='btn large btnType10' href='#none'><span>편곡 보컬 참여</span></a> " +
            "          <a class='btn large btnType11' href='#none'><span><i class='fa fa-share-square-o'></i> Share</span></a> " +
            "          <ul class='soundFooterRight'> " +
            "               <li> " +
            "                    <i class='fa fa-heart'></i> " +
            "                    <strong>15</strong> " +
            "               </li> " +
            "               <li> " +
            "                    <i class='fa fa-download'></i> " +
            "                    <strong>100</strong> " +
            "               </li> " +
            "               <li> " +
            "                    <i class='fa fa-dollar'></i> " +
            "                    <strong>100,000</strong> " +
            "               </li> " +
            "               <li> " +
            "                    <a href='#none'><span class='deletIcon'><i class='fa fa-trash'></i></span></a> " +
            "               </li> " +
            "          </ul> " +
            "       </div>" +
            "       <div class='commentWrap' style='display: none;'>" +
            "       <span class='commetText'>comment</span> " +
            "       <input type='text' style='width: 700px;' placeholder='글을 입력 하세요'>" +
            "       </div>" +
            "   </div>" +
            "</li>"
    );

    if (buttonSetType === "01") {
        $(".arrList li:last-child .btnType3, .arrList li:last-child .btnType4, .arrList li:last-child .btnType5, .arrList li:last-child .btnType9, .arrList li:last-child .btnType10, .arrList li:last-child .btnType11").remove();
        $(".soundFooterRight:last li:gt(1)").remove();
    } else if (buttonSetType === "02") {
        $(".arrList li:last-child .btnType5, .arrList li:last-child .btnType6, .arrList li:last-child .btnType7, .arrList li:last-child .btnType9, .arrList li:last-child .btnType10, .arrList li:last-child .btnType11").remove();
        $(".soundFooterRight:last li:gt(1)").remove();
    } else if (buttonSetType === "03") {
        $(".arrList li:last-child .btnType3, .arrList li:last-child .btnType4, .arrList li:last-child .btnType9, .arrList li:last-child .btnType10, .arrList li:last-child .btnType11").remove();
        $(".soundFooterRight:last li:gt(1)").remove();
    } else if (buttonSetType === "04") {
        $(".arrList li:last-child .btnType3, .arrList li:last-child .btnType4, .arrList li:last-child .btnType7, .arrList li:last-child .btnType8").remove();
        $(".soundFooterRight:last li:gt(2)").remove();
    } else if (buttonSetType === "05") {
        $(".arrList li:last-child .btnType3, .arrList li:last-child .btnType4, .arrList li:last-child .btnType7, .arrList li:last-child .btnType8").remove();
        $(".soundFooterRight:last li:lt(3)").remove();
    }
}

//10 fans탭, 10 playList탭의 추가 함수 addTopTenType1(이름, 팬합산개수, 팬등록 여부, 이미지경로)
function addTopTenType1(nick, count, fanFlag, img) {
    $(".tenFans").append(
            "<li>" +
            "   <a href='#none'><img src='" + img + "' alt=''></a>" +
            "   <div class='viewIcon'>" +
            "       <p><a href='#none'>" + nick + "</a></p>" +
            "       <div class='fanIcon'>" +
            "           <i class='fa fa-heart'></i>" +
            "           <strong>" + count + "</strong>" +
            "       </div>" +
            "   </div>" +
            "</li>"
    );

    if (fanFlag) {
        $(".tenFans li:last").append(
            "<div class='heartStat'><i class='fa fa-heart pointColorRed'></i></div>"
        )
    }
}

//10 Sponsor탭의 추가 함수 addTopTenType1(이름, 이미지경로)
function addTopTenType2(nick, img) {
    $(".tenSponsor").append(
            "<li>" +
            "   <div class='sponImg'><a href='#none'><img src='" + img + "' style='width: 100px; height: 100px;' alt=''></a></div>" +
            "   <p><a href='#none'>" + nick + "</a></p>" +
            "</li>"
    )
}

$(function () {
    //dropType1
    $('.dropType1').dropit();

//ajax list add test
    $(".testBtn").on("click", function () {
        addRowType1();
    });


    function addRowType2() {
        $(".arrList2").append(
                "<li>" +
                "   <div class='soundSource'>" +
                "       <p class='musician'>기타</p>" +
                "       <div class='soundArea'>" +
                "           <div class='soundHeader'>" +
                "               <a href='#none' class='bulPlay' data-sound-url='' data-sound-target=''><i class='fa fa-play-circle fa-2x'></i></a> " +
                "               <span class='songTitle'><input type='text' placeholder='선택한 연주자 이름'></span>" +
                "           </div>" +
                "           <div class='soundBody'>" +
                "               <div class='soundBar'></div>" +
                "               <div class='pajaImg'><img src='../../images/holderType2.gif' alt='' style='width: 100%;'></div>" +
                "           </div>" +
                "       </div>" +
                "       <div class='soundState'>연주중</div>" +
                "   </div>" +
                "</li>"
        );
    }

    addRowType2();

    //20141017 오디오컨트롤러 hide
    $(".audioSetWrap").hide();
    //play button toggle type1
    var ma2 = new Ma2rixInit('#audioSet');
    var sources = 'http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg';
    $(document).on("click", ".bulPlay", function () {
        ma2.stopAudio();
        var currentPlay = $(document).find(".bulPlay").index(this);
        $(document).find(".bulPlay i").not(':eq(' + currentPlay + ')').removeClass("fa-stop").addClass("fa-play-circle");
//        $(this).find("i").toggleClass("fa-play-circle fa-stop");
        if ($(this).find("i").hasClass("fa-play-circle")) {
            $(this).find("i").removeClass("fa-play-circle").addClass("fa-stop");
            ma2.startAuido(sources);
        } else if ($(this).find("i").hasClass("fa-stop")) {
            $(this).find("i").removeClass("fa-stop").addClass("fa-play-circle");
            ma2.stopAudio();
        }

        //20141017 오디오컨트롤러 show
        if ($(".audioSetWrap").is(':hidden')) {
            $(".audioSetWrap").slideDown(300);
        }
    });

    //commet show
    $(".commentWrap").hide();
    $(".arrList").on("click", ".btnType2", function () {
        if ($(this).attr('data-showing') == "0") {
            $(this).parents(".secType1").find(".commentWrap").css("opacity", 0.0).slideDown(300, function () {
                $(this).stop().animate({
                    "opacity": 1.0
                }, "slow");
            });
            $(this).attr('data-showing', '1');
        }
    });

    //tabType1
    $(".tabWrapType1").each(function () {
        $(this).find(".tabCont").hide().eq(0).show();
        $(this).find(".tabBtnSet1 > li > a").eq(0).addClass("active");
    });
    $(".tabBtnSet1 > li > a").click(function () {
        var getBtnIndex = $(this).parent().index();
        $(this).parent().parent().parent().find(">.tabCont").hide().eq(getBtnIndex).show();  //20141020중첩탭수정
        $(this).parent().parent().parent().find(">.tabBtnSet1 > li > a").removeClass("active").eq(getBtnIndex).addClass("active");  //20141020중첩탭수정
        $(this).parent().parent().parent().find(">.tabCont").eq(getBtnIndex).find(".tabBtnSet2 > li > a").removeClass("active");
        $(this).parent().parent().parent().find(">.tabCont").eq(getBtnIndex).find(".tabBtnSet2 > li > a").eq(0).addClass("active");
        $(this).parent().parent().parent().find(">.tabCont").eq(getBtnIndex).find(".tabCont").hide();
        $(this).parent().parent().parent().find(">.tabCont").eq(getBtnIndex).find(".tabCont").eq(0).show();
    });
    //tabType2
    $(".tabBtnSet2 > li > a").click(function () {
        var getBtnIndex = $(this).parent().index();
        $(this).parent().parent().parent().find(">.tabCont").hide().eq(getBtnIndex).show();  //20141020중첩탭수정
        $(this).parent().parent().parent().find(">.tabBtnSet2 > li > a").removeClass("active").eq(getBtnIndex).addClass("active");  //20141020중첩탭수정
    });


    //checkType1
    $(".hiddenBoxType1").hide();
    $("input[name*='openClose']").click(function () {
        if ($(this).parents(".arrInfoWrap").find("#closedVocal").is(":checked") == true) {
            $(".hiddenBoxType1").show();
        } else {
            $(".hiddenBoxType1").hide();
        }
    });

    //addLineType1
    $(".addLineType1").on("click", function () {
        if ($(this).parents(".arrInfoWrap").find("tr").length < 8) {
            $(this).parents(".hiddenBoxType1").find(".addTrType1").append(
                    "<tr>" +
                    "   <td><a href='#none' class='layerPopType3'><i class='fa fa-user'></i></a></td>" +
                    "   <td><input type='text'></td>" +
                    "   <td><a href='#none' class='layerPopType4'><i class='fa fa-envelope'></i></a></td>" +
                    "   <td><a href='#none' class='removeLineType1'><i class='fa fa-minus-circle'></i></a></td>" +
                    "</tr>");
        } else if ($(this).parents(".arrInfoWrap").find("tr").length > 7) {
            alert("보걸추가는 8개항목만 추가 가능합니다")
        }
    });
    $(".addTrType1").on("click", ".removeLineType1", function () {
        $(this).parents("tr").remove();
    });

    //addLineType2
    $(".addLineType2").on("click", function () {
        if ($(this).parents(".arrInfoWrap").find("tr").length < 8) {
            var musician = $(this).parents(".arrInfoWrap").find("select").val();
            var musicianName = $(this).parents(".arrInfoWrap").find(".musicianName").val();
            $(this).parents(".tabCont").find(".addTrType2").append(
                    "<tr>" +
                    "   <td>" + musician + "</td>" +
                    "   <td><a href='#none' class='layerPopType1'><i class='fa fa-user'></i></a></td>" +
                    "   <td><input type='text' placeholder='선택한 연주자 이름' value='' style='width: 200px;'></td>" +
                    "   <td><input type='text' style='width: 50px; text-align: right;'> % 배분</td>" +
                    "   <td><a href='#none' class='layerPopType2'><i class='fa fa-envelope'></i></a></td>" +
                    "   <td><a href='#none'><i class='fa fa-check-circle'></i></a></td>" +
                    "   <td><a href='#none'><i class='fa fa-external-link'></i></a></td>" +
                    "   <td><a href='#none' class='removeLineType1'><i class='fa fa-minus-circle'></i></a></td>" +
                    "</tr>"
            );
        } else if ($(this).parents(".arrInfoWrap").find("tr").length > 7) {
            alert("연주자는 8개항목만 추가 가능합니다")
        }

    });
    $(".addTrType2").on("click", ".removeLineType1", function () {
        $(this).parents("tr").remove();
    });

    // layer popup
    function layer_open(el) {
        var temp = $('#' + el);
        temp.parents('.layer').fadeIn();
        if (temp.outerHeight() < $(document).height()) {
            temp.css('margin-top', '-' + temp.outerHeight() / 2 + 'px')
        } else {
            temp.css('top', '0px');
        }
        if (temp.outerWidth() < $(document).width()) {
            temp.css('margin-left', '-' + temp.outerWidth() / 2 + 'px')
        } else {
            temp.css('left', '0px');
        }
        $('.layer .bg, .layer .btnClose').click(function (e) {
            $('.layer').fadeOut();
            e.preventDefault();
        });
    }

    $(document).on("click", ".layerPopType1", function () {
        layer_open("playerAppoint")
    });
    $(document).on("click", ".layerPopType2", function () {
        layer_open("msgSend")
    });
    $(document).on("click", ".layerPopType3", function () {
        layer_open("vocalSearch")
    });
    $(document).on("click", ".layerPopType4", function () {
        layer_open("msgSend")
    });

    //10 fans탭의 추가 함수 호출
    addTopTenType1("홍길동", 1000, true, "../../images/img_nonprofile.gif");
    addTopTenType1("김김김", 100, false, "../../images/img_nonprofile.gif");
    addTopTenType1("나나나", 3, true, "../../images/img_nonprofile.gif");

    //10 Sponsor탭의 추가 함수 호출
    addTopTenType2("조조조", "../../images/img_nonprofile.gif");
    addTopTenType2("조조조", "../../images/img_nonprofile.gif");
});