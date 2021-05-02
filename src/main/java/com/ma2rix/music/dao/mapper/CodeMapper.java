package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.Code;
import com.ma2rix.music.model.domain.CodeClass;

public interface  CodeMapper {
	public Code getCodeByCodeId(CodeClass clodeClass, Code code);
	public Code getCode(Code code);
	public Code getCode(CodeClass codeClass);
	
	public ArrayList<Code> getCodesByCodeClassId(String codeClassId);
	public ArrayList<Code> getCodesByCodeClass(CodeClass codeClass);
	public ArrayList<Code> getAllCodes();
}
