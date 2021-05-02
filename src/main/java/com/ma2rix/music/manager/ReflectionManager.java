package com.ma2rix.music.manager;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Reflection 를 이용하여 객체 프로퍼티를 복사 
 * 어플리케이션에서 사용되는 command 클래스는 domain 오브젝트에 폼 데이타 제공/ 수정을 위하여 몇개의 관리 필드 및 추가
 * 필드가 추가된 클래스로, 
 * 실제 디비에 수정/입력을 하기 위해서는 command 오브젝트가 domain 오브젝트로 변환해야 함  
 * 이 와중에 많은 게터/세터 메서드를 직접 호출해주어야 하는데, 이 불편을 막기 위해서 Reflection api 를 이용해 자동 카피함 
 * 
 * 차후 도메인객체를 상속받아서 command 클래스를 구성하게 되면, 자동 캐스팅이 되기 때문에 
 * 상속방식을 도입할 경우 좀더 별도의 수정없이 디비 작업이 가능
 *  
 * (현재는 command 클래스에 수많은 필드가 있고 ,이렇게 추가된 필드를 걸러내는것이  번거롭기 때문에 reflection 
 * 방식을 사용함 ---> 차후 상속을 통해서 필드 관리가 필요함 
 * 
 * @author
 *
 */
public class ReflectionManager {
	public static final ArrayList<String[]> beanPeorperties ;
	
	static {
		beanPeorperties = new ArrayList<String[]>();
		
	}
	
	/**
	 * 타켓 객체의 모든 필드를 복사.
	 * @param sourceObj  getter 을 호출할 원본 오브젝트  
	 * @param targetObj  setter 를 호출하여 복사하고자 하는 타켓 오브젝트 , 
	 */
	public static void reflectionCopy(Object sourceObj, Object targetObj) {
		Class<?> targetClass = targetObj.getClass();
		Class<?> sourceClass = sourceObj.getClass();

		Method[] targetMethods = targetClass.getDeclaredMethods();
		
		Class<?>[] targetParameters = null;
		String mName = null;

		for (int i = 0; i < targetMethods.length; i++) {
			mName = targetMethods[i].getName();
			targetParameters = targetMethods[i].getParameterTypes();
			
			if (mName.indexOf("set") == 0 && mName.length() > 3 && targetParameters.length == 1) {
				String propertyName = mName.substring(3);
				String	sourceMethodName = "get" + propertyName;
				try {
					/*sourceMethod = sourceClass.getDeclaredMethod(sourceMethodName,targetParameters[0]);*/
					Object value =  null;/*sourceMethod.invoke(sourceObj);*/
					for (Method m : sourceClass.getDeclaredMethods()){
						if (m.getName().equals(sourceMethodName)){
							value = m.invoke(sourceObj);
							Object[] callParameter = null;
							
							/*
							 * 	아래의 기본 타입의 프로퍼티 복사를 허용한다.
							 *  다른 타입의 복사를 원하면 관련 조건문을 추가 
							 *  */
							if (targetParameters[0] == String.class) {
								callParameter = new Object[]{ (String)value };
							} else if (targetParameters[0] == int.class) {
								callParameter = new Object[]{ (Integer)value };
							} else if (targetParameters[0] == long.class) {
								callParameter = new Object[]{ (Long) value };
							} else if (targetParameters[0] == double.class) {
								callParameter = new Object[]{ (Double) value };
							} else if (targetParameters[0] == float.class) {
								callParameter = new Object[]{ (Float) value };
							} else if (targetParameters[0] == Boolean.class) {
								callParameter = new Object[]{ (Boolean) value };
							}
							if (callParameter != null) {
								targetMethods[i].invoke(targetObj, callParameter);
								break;
							}
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} 
		}
	}
	
	/**
	 * 객체를 생성하여 복사하고 복사된 객체를 반환  
	 * @param sourceObj
	 * @param clz
	 * @return
	 */
	public Object  reflectionCopy(Object sourceObj,Class<?> clz){
		return null;
	}
	
	/**
	 * 음원 분류에 따라 프로퍼티 자동 복사 
	 * @param sourceObj
	 * @param targetObj
	 * @param permittedProperty 복사할 프로퍼티 이름 배열 
	 * @return
	 */
	public Object  reflectionCopyByMusic(Object sourceObj,Object targetObj,String sourceType){
		return null;
	}
	
	/**
	 * 지정된 프로피터만 복사
	 * @param sourceObj
	 * @param targetObj
	 * @param permittedProperty 복사할 프로퍼티 이름 배열 
	 * @return
	 */
	public Object  reflectionCopyPermitted(Object sourceObj,Object targetObj, String[] permittedProperty, String sourceType){
		String getPrefix = null; 
		return null;
	}
	
	/**
	 * 지정된 프로퍼티를 제외하고 복사 
	 * @param sourceObj
	 * @param targetObj
	 * @param permittedProperty 복사하지 않을 프로퍼티 이름 배열 
	 * @return
	 */
	public Object  reflectionCopyExcept(Object sourceObj,Object targetObj, String[] permittedProperty){
		return null;
	}
	
	
}
		
		
