/*
 * 이 자바 스크립트 클래스는 jPlayer 를 좀 더 편하게 다루기 위한 랩퍼 클래스
   재생 , 중지, 일시 중지, 백워드, 포워드 기능 및 재생 시간의 변화에 따른 리스너를 통해서  파형이미지위에서 
   알맞게 프로그레스 바가 이동되며  , 또한 파형 이미지에서 클릭할 경우 재생 위치로 변경된다 (옵션 설정 리스너)  

   클래스 생성 
   var ma2 = new Ma2rixInit(아래의 매개 변수);

   audioSelector : jPlayer 가 위치할 DIV의 ID 혹은 jquery 개체   

   ma2.startAuio(sourcesString); 오디오 재생 , source 는 여러개의 소스를 지정할 수 있으며 각 소스는 세미콜론으로 분리한 문자열 
   ma2.stopAudio(); 오디오 중지

 
*/

	var Ma2rixInit = function(audioSelector){
		this.audioSet = (typeof audioSelector  == 'string')? $(audioSelector): audioSelector;
		
		this.currentTime = 0;
		this.duration = 0;
		this.isReady = false;
		this.isPlaying = false;
		
		this.sources = null;
		this.targetArr = null;
	   
		
		this.init();
	};

	Ma2rixInit.prototype = {
		init : function(){
			this.audioSet.jPlayer({
				ready : function (){
					this.isReady = true;
			    },
			    swfPath: "/music/js",
			    supplied: "m4a, oga"
			});
			this.setInitListener();
		},
		
		setInitListener : function(){
			this.audioSet.jPlayer({
				ready : function(event){ this.isReady   = true ;},
				play  : function(event){ this.isPlaying = true ;},
				pause : function(event){ this.isPlaying = false;},
				ended : function(event){ this.isPlaying = false;}  	/* PlayList 가 존재할 때 사용*/
			});	
		} ,
		
		/*
		 * 재생 시간에 따라 프로그레스 막대 이동 처리 리스너 
		 * clicakbalePane   : 클릭할 jquery 개체 ( 주로 파형 이미지)
		 * progressSelector : prgress 를 나타낼 jquery 개체 (진행막대) 
		 */
		
		setProgressUpdateListener : function(clicakbalePane , progressSelector){
			this.frequency = clickablePane;
			this.progress = progressSelector;
			
			if (this.isProgressUpdatable()){
				this.audioSet.jPlayer({
					timeupdate : function(event){
						this.updateProgress(event);
					}
				});	
			}
		},
		
		updateProgress : function(event){
			var elapsedTime = this.currentTime = Math.round(event.jPlayer.status.currentTime);
			var duration = this.duration =  Math.round(event.jPlayer.status.duration);
			var progressX = (elapsedTime / duration) * this.frequency.width(); 
			this.progress.css('left', progressX);
		},
		
		/*
		 * 파형 이미지 영역을 클릭하여 재생 위치의 변경기능을 추가하는 리스너 
		 * clicakbalePane   : 클릭할 jquery 개체 ( 주로 파형 이미지)
		 * progressSelector : prgress 를 나타낼 jquery 개체 (진행막대) 
		 */
		setClickUpdateListener : function(clicakbalePane , progressSelector){
			this.frequency = clickablePane;
			this.progress = progressSelector;
			this.clickUpdatable = true;
			
			if (this.isClickUpdatable()){
				this.frequency.click(function(event){
					var playHead = (event.pageX - $(this).offset().left() / frequency.width()) * 100; 
					this.audioSet.jPlayer('playHead', playHead);
				});
			}
		},
		
		/* 
		 * 오디오 재생 , 매개변수 타입은 세미콜론으로 연결된 소스 스트링
		 */
		startAuido : function(targetSources){
			this.sources = targetSources;
			targetArr = targetSources.split(';');
			
			this.audioSet.jPlayer('setMedia', {
				title : targetArr[0],
				m4a : targetArr[0],
				oga : targetArr[1]
			});
			this.audioSet.jPlayer('play');
		},
		
		/* 
		 * 오디오 중지 
		 */
		stopAudio : function(){
			this.audioSet.jPlayer('stop');
		},
		
		/* 
		 * 오디오 객체 리셋 , 다시 플레이 하기 위해서는 setMedia 속성을 설정해주어야 함  
		 */
		clearMedia : function(){
			audioSet.jPlayer('clearMedia');
		},
		
		/* 
		 * 현재 재생 여부 
		 */
		isPlaying : function(){
			return this.isPlaying;
		},
		
		/* 
		 * 패인을 클릭하여 재생위치를 조절할 수 있는 지 여부  반환 
		 */
		isClickUpdatable : function(){
			return this.frequency && this.progress && this.clickUpdatable;
		},
		
		/* 
		 * 재생 시간에 따라 진행바를 움직일 수 있는 지 여부 반환
		 */
		isProgressUpdatable : function(){
			return this.frequency && this.progress;
		}
	};


