package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.CodeDao;
import com.ma2rix.music.dao.mapper.CodeClassMapper;
import com.ma2rix.music.dao.mapper.CodeMapper;
import com.ma2rix.music.model.domain.Code;
import com.ma2rix.music.model.domain.CodeClass;

@Repository
public class CodeDaoImpl implements CodeDao {
	
	@Autowired
	CodeMapper codeMapper;
	
	@Autowired
	CodeClassMapper codeClassMapper;
	

	@Override
	public Code getCodeByCodeId(CodeClass codeClass, Code code) {
		return codeMapper.getCodeByCodeId(codeClass,code);
	}

	@Override
	public Code getCode(Code code) {
		return codeMapper.getCode(code);
	}

	@Override
	public ArrayList<Code> getCodesByCodeClass(CodeClass codeClass) {
		return codeMapper.getCodesByCodeClass(codeClass);
	}

	@Override
	public ArrayList<CodeClass> getAllCodeClasses() {
		return codeClassMapper.getAllCodeClasses();
	}

	@Override
	public ArrayList<Code> getAllCodes() {
		return codeMapper.getAllCodes();
	}

	@Override
	public Code getCode(CodeClass codeClass) {
		return null;
	}

	@Override
	public ArrayList<Code> getCodesByCodeClassId(String codeClassId) {
		return codeMapper.getCodesByCodeClassId(codeClassId);
	}
	
	

}
