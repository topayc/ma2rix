package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.CodeDao;
import com.ma2rix.music.model.domain.Code;
import com.ma2rix.music.model.domain.CodeClass;
import com.ma2rix.music.service.interfaces.CodeService;

@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	CodeDao codeDao;

	@Override
	public Code getCodeByCodeId(CodeClass clodeClass, Code code) {
		return codeDao.getCodeByCodeId(clodeClass, code);
	}

	@Override
	public Code getCode(Code code) {
		return codeDao.getCode(code);
	}

	@Override
	public ArrayList<Code> getCodesByCodeClass(CodeClass codeClass) {
		return codeDao.getCodesByCodeClass(codeClass);
	}

	@Override
	public ArrayList<CodeClass> getAllCodeClasses() {
		return codeDao.getAllCodeClasses();
	}

	@Override
	public ArrayList<Code> getAllCodes() {
		return codeDao.getAllCodes();
	}

	@Override
	public Code getCode(CodeClass codeClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Code> getCodesByCodeClassId(String codeClassId) {
		return codeDao.getCodesByCodeClassId(codeClassId);
	}

}
