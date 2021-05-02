/* COMMON SETTING VARIABLE */
var $$_progress_z_index = 999;
var $$_progress_width = "600px";
var $$_progress_border = "none";
var $$_progress_border_radius = "0px";
var $$_progress_background = "none";
var $$_progress_msg_font_type = "맑은 고딕";
var $$_progress_msg_font_size = "14px";
var $$_progress_msg_font_color = "#000000";

/* LOOP TYPE PROGRESS SETTING VARIABLE */
var $$_loop_progress_gif_img_path = "../resources/images/progress/loading1.gif";
var $$_loop_progress_gif_img_width = "32px";
var $$_loop_progress_gif_img_height = "32px";


/**
 * - 상단에 선언된 변수들은 사용 환경 및 취향에 따라 수정하여 사용할 수 있습니다.
 * - 본 Library 는 j-query 기반으로 작성되었으므로 반드시 먼저 j-query library 가 선행되어야 합니다.
 * 
 * 
 * ※ 상단 변수에대한 설명 ( 공통적용 ※ 현 버전에서는 loop type progress 만 존재하나, 향후 분리를 위해 구분해 두었음 )
 * 		$$_progress_z_index : progress 팝업레이어의 z-index 값 [ 기본값 999로 지정되어있으나, 사용 환경에 따라 최 상위에 올라올수 있도록 조절하십시오 ] 
 * 		$$_progress_width	: progress 팝업레이어의 width 값 [ 호출시 입력하는 메시지의 길이에 따라 달라질 수 있으니, 사용 환경에 맞추어 조절하십시오 ]
 * 		$$_progress_border	: progress 팝업레이어의 border 값 [ 적용하고 싶지 않은 경우 none 을 입력하십시오 ]
 * 		$$_progress_border_radius	: progress 팝업레이어의 border_radius 값 [ border 의 라운딩을 적용합니다, IE-8 이하의 버전에선 적용이 되지 않습니다, $$_progress_border 값을 참고하여 적용하시고 적용하고 싶지 않을 시 0px 을 입력하십시오 ]
 * 		$$_progress_background		: progress 팝업레이어의 background 컬러값 [ 기본값 #FFFFFF(화이트) 이 적용되어 있습니다, 적용하고 싶지 않은 경우 none 을 입력하십시오 ]
 * 		$$_progress_msg_font_type	: progress 팝업레이어의 메시지 문자의 font 를 지정합니다.
 * 		$$_progress_msg_font_size	: progress 팝업레이어의 메시지 문자의 font size 를 지정합니다.
 * 		$$_progress_msg_font_color	: progress 팝업레이어의 메시지 문자의 font color 를 지정합니다.
 * 
 * ※ 상단 변수에대한 설명 ( LOOP TYPE PROGRESS )
 * 		$$_loop_progress_gif_img_path	: loop type progress 에 적용될 반복형 GIF 이미지의 경로값 + 파일명을 지정합니다.
 * 		$$_loop_progress_gif_img_width	: loop type progress 에 적용될 반복형 GIF 이미지의 width 값을 지정합니다.
 * 		$$_loop_progress_gif_img_height : loop type progress 에 적용될 반복형 GIF 이미지의 height 값을 지정합니다.
 * 
 * 
 * ※ 본 Library 의 사용방법 ※
 * 
 * 		1. 페이지 로딩시 또는 필요한 타이밍에 적용하고자 하는 유형의 PROGRESS 팝업레이어의 INIT 함수를 반드시 호출하여 해당 레이어를 구성하도록 합니다 [ DISPLAY:NONE 이 적용이 되어있으므로 바로 보이지 않습니다 ]
 * 			- 해당 PROGRESS 팝업레이어를 나타내기전에 반드시 해당 PROGRESS의 INIT 함수가 호출되어야 합니다 [ 추후 다른 TYPE 의 PROGRESS 도 추가하기위해 TYPE 별 INIT 함수 제공 ]
 *			- LOOP TYPE PROGRESS INIT 함수 > $$loop_progress_init()
 *
 * 		2. 해당 PROGRESS 팝업레이어를 나타내고자 하는 타이밍에 해당 PROGRESS의 SHOW 함수를 호출합니다.
 * 			- LOOP TYPE PROGRESS SHOW 함수 > $$open_loop_progress( msg )
 * 				: msg 인자는 PROGRESS 팝업레이어를 보여줄때 나타내고자 하는 메시지입니다, 입력하지 않을시 기본 적용된 [ LOADING... ] 문구를 출력하며, 입력한 경우 입력한 문구를 출력합니다.
 * 			- LOOP TYPE TIMER PROGRESS SHOW 함수 > $$open_loop_timer_progress ( msg )
 * 				: msg 인자는 PROGRESS 팝업레이어를 보여줄때 나타내고자 하는 메시지입니다, 입력하지 않을시 기본 적용된 [ 소요시간 : X 초 ] 문구만 출력하며, 입력한 경우 입력한 문구 + 줄바꿈 + [ 소요시간 : X 초 ] 를 출력합니다.
 * 				: 본 LOOP TYPE TIMER PROGRESS 함수는 TIMER 적용에 따른 매 초당 반복 재귀함수를 호출하므로 반드시 제공되는 HIDE 함수를 통해 종료해 주세요.
 * 
 * 		3. 해당 PROGRESS 팝업레이어를 감추고자 하는 타이밍에 해당 PROGRESS의 HIDE 함수를 호출합니다.
 * 			- LOOP TYPE PROGRESS HIDE 함수 > $$close_loop_progress()
 * 			- LOOP TYPE TIMER PROGRESS HIDE 함수 > $$close_loop_timer_progress() : 본 함수는 재귀함수를 종료하는 로직이 포함되어 있습니다.
 * 
 * 
 * ※ 제공 함수 정리
 * 		- $$loop_progress_init() 				: LOOP TYPE PROGRESS 팝업레이어의 초기화 및 구성함수
 * 		- $$open_loop_progress( msg )			: LOOP TYPE PROGRESS 팝업레이어의 SHOW 함수
 * 		- $$close_loop_progress()				: LOOP TYPE PROGRESS 팝업레이어의 HIDE 함수
 * 		- $$open_loop_timer_progress ( msg )	: LOOP TYPE TIMER PROGRESS 팝업레이어의 SHOW 함수
 * 		- $$close_loop_timer_progress()			: LOOP TYPE TIMER PROGRESS 팝업레이어의 HIDE 함수
 * 
 * 
 * ※ 테스트 브라우저 및 적용된 기능
 * 		- 테스트 브라우저	: IE 8, 9, 10 / FIREFOX / CHROME
 * 		- 적용된 기능		: 브라우저 RESIZE 이벤트 및 SCROLL 이벤트에 대하여 PROGRESS 팝업레이어가 항상 브라우저의 가운데에 위치할수 있도록 적용
 * 
 * 
 * ※ version 1.0
 * ※ 버전 히스토리
 * 		- 2014.10.16 version 1.0 최초작성
 * 
 * # 라이선스 : 본 파일의 파일명 수정금지, 본 상단 SETTING 변수를 제외한 소스의 수정 금지 조건으로 자유배포 허용
 * # 버그신고 및 문의 : j_developer@naver.com
 * @author j_developer@naver.com
 */

/** TIMER TYPE LOOP PROGRESS VARIABLE  **/
var $$_timer_loop = true;
var $$_time = 0;

/** LOOP TYPE PROGRESS INITIALIZE **/
var $$loop_progress_init = function(){
	var loop_progress = $( document.createElement("div") );			/* progress popup */
	loop_progress.css({
		'padding' : '20px',
		'width' : $$_progress_width,
		'text-align' : 'center',
		'position' : 'absolute',
		'border' : $$_progress_border,
		'border-radius' : $$_progress_border_radius,
		'background' : $$_progress_background,
		'display' : 'none',
		'z-index' : $$_progress_z_index,
		'left' : '0px',
		'top' : '0px'
	}).attr('id', '__loop_progress');
	var progress_img = $( document.createElement("div") );
	progress_img.css({
		'margin' : '0px',
		'padding' : '0px',
		'width' : $$_loop_progress_gif_img_width,
		'height' : $$_loop_progress_gif_img_height,
		'display' : 'inline-block',
		'background' : 'url("' + $$_loop_progress_gif_img_path + '")'
	});
	var progress_msg = $( document.createElement("div") );
	progress_msg.css({
		'margin-top' : '10px',
		'text-align' : 'center',
		'font-family' : $$_progress_msg_font_type,
		'font-size' : $$_progress_msg_font_size,
		'font-weight' : 'bold',
		'color' : $$_progress_msg_font_color
	}).html("<label id='__loop_progress_msg'></label>");
	loop_progress.append( progress_img ).append( progress_msg );
	$('body').append( loop_progress );
	
	var correction= 60;			// PROGRESS POPUP 생성위치 보정값
	var inner_height = 0;
	var inner_width = 0;
	var progress_height = loop_progress.height();
	var progress_width = loop_progress.width();
	var scroll_top = 0;
	
	/** BROWSER RESIZING AND SCROLL EVENT SUPPORT **/
	$(window).resize(function(){
		inner_height = window.innerHeight == null ? document.documentElement.scrollHeight - correction : window.innerHeight - correction;
		inner_width = window.innerWidth == null ? document.documentElement.scrollWidth - correction : window.innerWidth - correction;
		scroll_top = $(window).scrollTop();
		loop_progress.css({
				'left' : inner_width / 2 - progress_width / 2,
				'top' : inner_height / 2 - progress_height / 2 + scroll_top,
		});
	});
	$(window).scroll(function(){
		$(window).trigger('resize');
	});
	$(window).trigger('resize');
};

/** LOOP TYPE PROGRESS INITIALIZE  **/
var $$open_loop_progress = function( _progress_msg ){
	$('#__loop_progress_msg').html( _progress_msg == null || _progress_msg == "" ? "LOADING..." : _progress_msg );
	$('#__loop_progress').show();
};
var $$close_loop_progress = function(){
	$('#__loop_progress').hide();
};

/** LOOP TYPE TIMER PROGRESS INITIALIZE  **/
var $$open_loop_timer_progress = function( _progress_msg ){
	_progress_msg = _progress_msg == null || _progress_msg == "" ? "소요시간 : <label id='__time'></label> 초" : "<p>" + _progress_msg + "</p><p style='margin-top: 10px';>소요시간 : <label id='__time'></label> 초</p>";
	$('#__loop_progress_msg').html( _progress_msg );
	$('#__loop_progress').show();
	$$_timer_loop = true;
	$$_timeCount();
};
var $$close_loop_timer_progress = function(){
	$$_timer_loop = false;
	$$_time = 0;
	$('#__loop_progress').hide();
};
function $$_timeCount(){
	if( $$_timer_loop ){
		$('#__time').html( $$_time );
		setTimeout( "$$_timeCount()", 1000);
		$$_time ++;
	}
}