/*

 * jPlayer 사용을 위한 자바스ㄴ크립트 랩퍼 클래스 
 * 제공 기능
 * - 재생, 중지, 일시 중지, 백워드 , 포워드 
 * - 재생 시간의 변화에 따른 프로그레스 이동 
 * - 프로그레스 막대를 드래그함으로써 재생위치 변경 
 * - 플레이 리스트 및 플레이 리스트 반복 재생 
 * - 셀렉터에 의한 자동 플레이 리스트 등록 
 * 
 * 클래스 생성 
 * var ma2 = new Ma2rixInit(jPlayer로 사용하고자 하는 id Selector);
 * 재생
 * ma2.startAuio(sourcesString);
 * 중지 
 *  ma2.stopAudio()
 * 각 음원별 재생을 위해서는 음원마다 해당 플레이어 객체를 생성해준다.
 * (페이지 이동시 음원 재생 중지 리스너 추가 예정) 
*/

	var Ma2rixInit = function(audioSelector){
		this.audioSet = (typeof audioSelector  == 'string')? $(audioSelector): audioSelector;
		
		this.playList = [];
		this.curJSelector = null;
		this.curPlayingCount = -1;
		this.curPlaySoundTitle  = '';
		this.curPlaySoundSrc = '';
		
		this.currentTime = 0;
		this.duration = 0;
		this.isReady = false;
		this.isPlaying = false;
		this.playListLoop = false;
		
		this.sources = null;
		this.targetArr = null;
		this.init();
	};

	/*함수 정의 */
	Ma2rixInit.prototype = {
		init : function(){ 
			this.curJSelector = null;
			this.curPlaySoundSrc = '';
			this.curPlaySoundTitle = '';
			this.setInitListener();
		},
		
		/*
		 * 기본 리스너 및 초기 환경 설정
		 * 플레이어와 페이지 상의 플레이버튼의 작동을 동기화 
		 * */
		setInitListener :  function(){
			var context = this;
			this.audioSet.jPlayer({
				/* PlayList 기능이 필요할 경우  및 기타의 경우에 필요한  이벤트 리스너를 추가*/
				ready: function(event){
					context.isReady   = true ;
				},
				play : function(event){ 
					context.isPlaying = true;
					context.curJSelector.find('i').
						removeClass('fa-play-circle').addClass('fa-stop');
				},
				pause : function(event){ 
					context.isPlaying = false;
					if (context.curJSelector != null){
						context.curJSelector.find('i').
							removeClass('fa-stop').
							addClass('fa-play-circle')
					}
				},
				ended : function(event){ 
					context.isPlaying = false;
					if (context.curJSelector != null){
						context.curJSelector.find('i').
							removeClass('fa-stop').
							addClass('fa-play-circle')
					}
				},
				swfPath: "/music/js",
				supplied: "m4a, oga"
			});	
		} ,
		
		/*
		 * 재생 시간에 따라 프로그레스 막대 이동 처리 리스너 
		 * clicakbalePane   : 클릭할 jquery 개체 ( 매투리스 사이트에서는 파형 이미지)
		 * progressSelector : progress 를 나타낼 jquery 개체 (진행막대) 
		 */
		
		setProgressUpdateListener : function(clicakbalePane , progressSelector){
			this.frequency = clickablePane;
			this.progress = progressSelector;
			var context = this;
			
			if (this.isProgressUpdatable()){
				  this.audioSet.jPlayer({
					timeupdate : function(event){
						context.updateProgress.call(context, event);
					}
				});	
			}
		},
		
		/* 리스너 호출되는 메서드로 재생 시간 변화에 따라  막대를 이동
		 * 재생 시간에 변함에 따라 내부적으로 자동으로 호출됨
		 * */
		updateProgress : function(event){
			var elapsedTime = this.currentTime = Math.round(event.jPlayer.status.currentTime);
			var duration = this.duration =  Math.round(event.jPlayer.status.duration);
			var progressX = (elapsedTime / duration) * this.frequency.width(); 
			this.progress.css('left', progressX);
		},
		
		/*
		 * 파형 이미지 영역을 클릭하여 재생 위치의 변경기능을 추가하는 리스너 
		 * clicakbalePane   : 클릭할 jquery 개체 ( 매투리스 사이트에서는 파형 이미지)
		 * progressSelector : prgress 를 나타낼 jquery 개체 (진행막대) 
		 */
		setClickUpdateListener : function(clicakbalePane , progressSelector){
			this.frequency = clickablePane;
			this.progress = progressSelector;
			this.clickUpdatable = true;
			var context = this;
			
			if (this.isClickUpdatable()){
				this.frequency.click(function(event){
					var playHead = (event.pageX - $(this).offset().left() / frequency.width()) * 100; 
					context.audioSet.jPlayer('playHead', playHead);  
				});
			}
		},
		
	
		/**
		 * 인자로 주어진 소스 스트링으로 부터 음원 url 를 분리하여 음원을 재생
		 * @param targetTitle      음원의 제목 
		 * @param targetSources    세미콜론으로 구분되는 음원 URL (mp3 , ogg 순이어야 함 
		 *   				      "http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg" 의 형태임         
		 */
		startAuidoSource : function(targetTitle, targetSources){
			this.init();
			this.curPlaySoundSrc = targetSources;
			this.curPlaySoundTitle = targetTitle
			var targetArr = this.getSplitedAudioSource(targetSources)
			
			this.audioSet.jPlayer('setMedia', {
				title : this.curPlaySoundTitle,
				m4a : targetArr[0],
				oga : targetArr[1]
			});
			this.audioSet.jPlayer('play');
		},
		
		/**
		 * 인자로 주어진 소스 스트링으로 부터 음원 url 를 분리하여 음원을 재생
		 * @param audioPlaySelector     음원 정보를 가지고 있는 버튼등의 셀렉터 (셀렉터 문자열 혹은 jquery 개체 타입)  
		 */
		startAuidoPlaySelector : function(audioPlaySelector){
			this.init();
			this.curJSelector = (typeof audioPlaySelector  == 'string')? $(audioPlaySelector): audioPlaySelector;
		
			this.curPlaySoundSrc = this.curJSelector.attr("data-sound-url");
			this.curPlaySoundTitle = this.curJSelector.attr("data-sound-title");
			var targetArr = this.getSplitedAudioSource(this.curPlaySoundSrc)
			
			this.audioSet.jPlayer('setMedia', {
				title : this.curPlaySoundTitle,
				m4a : targetArr[0],
				oga : targetArr[1]
			});
			this.audioSet.jPlayer('play');
		},
		
		/**
		 * 세미콜론으로 연결된 음원 url 을 잘라서 배열로 반환  
		 * @param audioSource)   세미콜론으로 연결된 음원 url
		 */
		getSplitedAudioSource : function(audioSource){
			return audioSource.split(';');
		},
		
		/* 
		 * 오디오 중지 
		 */
		stopAudio : function(){
			this.audioSet.jPlayer('stop');
		},
		
		/* 
		 * 오디오 일시 중지
		 */
		pauseAudio : function(){
			this.audioSet.jPlayer('pause');
		},
		
		
		/* 
		 * 음원 소스를 플레이 리스트에 추가
		 * 개별 음원 이름과 소스를 플레이 리스트에 추가한다.
		 * 인자 옵션 구조 
		 * 
		 * {
		 * 	 soundTitle: 사운드 제목,
		 * 	 soundSrc : 사운드 소스 
		 * }
		 * 
		 * @param soundOption 음원 URL 이거나 option 객체일수 있음 (옵션 객체일 경우 2번째 매개변수는 무시되며, 이 옵션객체로 부터 
		 *                    위 형태의 오브젝트를 생성하여 리스트에 추가한다. 스트링일 경우 첫번째 , 2번재 매개변수를 모두 사용하여
		 *                    오브젝트를 만들어 리스트에 추가 
		 * @param oundUrl     음원 URL ,   soundOption 변수 타입이 옵션객체일 경우 무시됨               
		 */
		addPlayList : function(soundOption,soundUrl){
			if (typeof soundOption == 'string'){
				this.playList.push({soundTitle : soundOption, soundSrc : soundUlr});
			}else {
				this.playList.push({soundTitle: soundOption.title, soundSrc: soundOption.src});
			}
		},
		
		/**
		 * 인자로 주어진 소스 스트링으로 부터 음원 url 를 분리하여 음원을 재생
		 * @param soundSelector      음원 데이타를 가지고 있는 셀렉터 문자열 혹은 jquery 개체
		 * @param soundTitleAttr     해당 음원의 제목을 가져올 셀렉터의 속성 이름 
		 * @param soundSourceAttr    해당 음원의 음원 URL 정보를 가져올 셀렉터의 속성이름 
		 * 
		 * 2, 3번째 매개변수가 넘어오지 않는다면 기본 default 속성 이름을 이용하여 값을 추출한다.
		 */
		addPlayListSelector : function(soundSelector, soundTitleAttr, soundSourceAttr){
			//사운드 타이틀 및 사운드 소스 경로 설정
			// soundTitleAttr, soundSourceAttr 이 설정되어 있지 않을 경우 기본 default 속성이름으로 설정 
			var titleAttr = soundTitleAttr || 'data-sound-title';
			var sourceAttr = soundSource || 'data-sound-url';
			var jSoundObj = (typeof soundSelector == 'string'? $(soundSelector) : soundSelector);
			
			jSoundObj.each(function(){
				var title  = $(this).attr(titleAttr);
				var src = $(this).attr(sourceAttr);
				this.playList.push({soundTitle : title, soundSrc : src});
			});
		},
		
		
		/*
		 * 플레이 리스트를 초기화한다. 
		 */
		clearPlayList : function(){ 
			this.playList = [];
		},
		
		/* 
		 * 오디오 객체 리셋 , 다시 플레이 하기 위해서는 setMedia 속성을 설정필요 
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
		},
		
		/* 
		 * 다음 곡 연주
		 */
		playNext : function(){
			if (this.canPlayNext()){
				this.curPlayCount++; 
				if (this.getPlayListLoop()){
					if (this.curPlayCount >= this.playList.length ){
						this.curPlayCount = 0;
					}
				}
				this.stopAudio();
				var playSource = playList[this.curPlayCount];
				this.curPlaySoundTitle = playSource.soundTitle;
				this.curPlaySoundSrc = playSource.soundSrc;
				this.startAudio(playSource.soundTitle, playSource.soundSrc);
			}
		},
		
		/* 
		 * 이전곡 연주
		 */
		playPrev : function(){
			if (this.canPlayPrev()){
				this.curPlayCount--; 
				if (this.getPlayListLoop()){
					if (this.curPlayCount < 0 ){
						this.curPlayCount = this.playList.length -1;
					}
				}
				this.stopAudio();
				var playSource = playList[this.curPlayCount];
				this.curPlaySoundTitle = playSource.soundTitle;
				this.curPlaySoundSrc = playSource.soundSrc;
				this.startAudio(playSource.soundTitle, playSource.soundSrc);
			}
		},
		
		/* 
		 * 다음곡 연주가 가능한지 반환 
		 */
		canPlayNext : function(){
			if (this.playListLoop){ return true;}
			if (this.curPlayingCount < this.playList.length){ return true;
			}else { return false;}
		},
		
		/* 
		 * 이전곡 연주가 가능한지 반환 
		 */
		canPlayPrev : function(){
			if (this.playListLoop){return true;}
			if (this.curPlayingCount > 0){	return true;
			}else { return false;}
		},
		

		/**
		 * 재생순서가 처음, 마지막일때 다음 재생, 이전 재생를 눌렀을 때 자동 루프 여부  
		 * @param loop  true , false 로 평가될 수 있는 값(간단하게 true, false 로 세팅)
		 */
		setPlayListLoop : function(loop){
			this.playListLoop = loop;
		},
		
		getPlayListLoop : function(){
			return this.playListLoop;
		}
	};


