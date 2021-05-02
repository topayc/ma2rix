/**
 * 인자로 전달된 로케일에 대항하는 메시지 파일을 읽어서  자바 스크립트 객체를 생성
 * @param en, ko 등의 언어 문자열
 */
function loadBundles(lang) {
        jQuery.i18n.properties({
            name:'message', 
            path:'/locale/properties/', 
            mode:'both',
            language:lang, 
            callback: function() {}
    });
}

/**
 * 메시지를 읽어온다. 프레임 중첩등의 경우도 발생할 수 있기 때문에 
 * 자신이 부모 프레임이 아닐 경우 부모 프레임의 함수를 재 호출한다.
 * @param msg
 * @returns
 */
function i18n(msg) {
    var args = "\""+ msg + "\"";
    for (var i = 1; i < arguments.length; i++) {
           args += ", \"" + arguments[i] + "\"";
    }
    if (parent != this) {
           return eval("parent.i18n(" + args + ")");
    }
    return eval("jQuery.i18n.prop(" + args + ")");
}