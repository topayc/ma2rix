package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.Code;
import com.ma2rix.music.model.domain.CodeClass;

public interface CodeDao {
	public Code getCodeByCodeId(CodeClass clodeClass, Code code);
	public Code getCode(Code code);
	public Code getCode(CodeClass codeClass);
	
	public ArrayList<Code> getCodesByCodeClass(CodeClass codeClass);
	public ArrayList<Code> getCodesByCodeClassId(String codeClassId);
	public ArrayList<CodeClass> getAllCodeClasses();
	public ArrayList<Code> getAllCodes();
}
