package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.Code;
import com.ma2rix.music.model.domain.CodeClass;

@Transactional
public interface CodeService {
	
	public Code getCodeByCodeId(CodeClass clodeClass, Code code);
	public Code getCode(Code code);
	public Code getCode(CodeClass codeClass);
	
	public ArrayList<Code> getCodesByCodeClass(CodeClass codeClass);
	public ArrayList<Code> getCodesByCodeClassId(String codeClassId);
	public ArrayList<CodeClass> getAllCodeClasses();
	public ArrayList<Code> getAllCodes();
	
}
