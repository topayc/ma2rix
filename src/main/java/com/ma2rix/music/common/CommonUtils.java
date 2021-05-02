package com.ma2rix.music.common;

/**
 * 유틸 클래스 
 * @author v
 *
 */
public class CommonUtils {
	
    
    /**
     * <p> 이메일의 전체문자열 1개 입력 받아 유요한 이메일형식인지 검사.</p>
     * @param   이메일 문자열 (1개)
     * @return  유효한 이메일 형식인지 여부 (True/False)
     */
    public static boolean checkFormatMail(String mail) {
                 
         String[] temp = mail.split("@");       // '@' 를 기점으로 앞, 뒤 문자열 구분
         
         if(temp.length == 2) return checkFormatMail(temp[0], temp[1]);
         else return false;
    }
	
    public static boolean isNullOrEmpty(String str) {
		if (str == null || "".equals(str.trim())){
			return true;
		}else {
			return false;
		}
	}
	
	/**
     * <p> 이메일의  앞, 뒤 문자열 2개 입력 받아 유요한 이메일형식인지 검사.</p>
     * @param   이메일 문자열 (2개)
     * @return  유효한 이메일 형식인지 여부 (True/False)
     */
    public static boolean checkFormatMail(String mail1, String mail2) {
                 
         int count = 0;
                 
         for(int i = 0; i < mail1.length(); i++){
                 if(mail1.charAt(i) <= 'z' && mail1.charAt(i) >= 'a') continue;         
                 else if(mail1.charAt(i) <= 'Z' && mail1.charAt(i) >= 'A') continue;    
                 else if(mail1.charAt(i) <= '9' && mail1.charAt(i) >= '0') continue;    
                 else if(mail1.charAt(i) == '-' && mail1.charAt(i) == '_') continue;    
                 else return false;
         }      // 유효한 문자, 숫자인지 체크
                                                 
         for(int i = 0; i < mail2.length(); i++){       
                 if(mail2.charAt(i) <= 'z' && mail2.charAt(i) >= 'a') continue;
                 else if(mail2.charAt(i) == '.'){ count++;  continue;}
                 else return false;
         }      // 메일 주소의 형식 체크(XXX.XXX 형태)             
                 
         if(count == 1) return true;
         else  return false;    
    }
    
    /**
     * String을 숫자로 변환 , 변환 오류시 디폴트 값 반환 
     */
    public static int str2int(String txt, int mydefault) {
		int num = 0;
		if (txt == null || "".equals(txt)) {
			num = mydefault;
		} else {
			try {
				num = Integer.parseInt(txt);
			} catch (NumberFormatException e) {
			}
		}
		return num;
	}
    
    /**
     * 스트링을 숫자타입으로 변환 
     */
    public static int str2int(String txt) {
		int num = 0;
		if (txt == null || "".equals(txt)) {
			try 
			{
				num = Integer.parseInt(txt);
			} catch (NumberFormatException e) {
			}
		}
		return num;
	}
}
