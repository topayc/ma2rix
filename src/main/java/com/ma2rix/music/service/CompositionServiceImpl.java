package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.CompositionDao;
import com.ma2rix.music.manager.AppConstants;
import com.ma2rix.music.manager.ReflectionManager;
import com.ma2rix.music.model.command.ArrangeVocalCommand;
import com.ma2rix.music.model.command.ArrangementCommand;
import com.ma2rix.music.model.command.ComposeArrangeCommand;
import com.ma2rix.music.model.command.ComposeUpdateCommand;
import com.ma2rix.music.model.command.CompositionCommand;
import com.ma2rix.music.model.command.PerformanceCommand;
import com.ma2rix.music.model.domain.ArrangeVocal;
import com.ma2rix.music.model.domain.Arrangement;
import com.ma2rix.music.model.domain.ComposeArranger;
import com.ma2rix.music.model.domain.Composition;
import com.ma2rix.music.model.domain.Performance;
import com.ma2rix.music.service.interfaces.ArrangeVocalService;
import com.ma2rix.music.service.interfaces.ComposeArrangerService;
import com.ma2rix.music.service.interfaces.CompositionService;


@Service
public class CompositionServiceImpl implements CompositionService {
	
	public static final int BATCH_ACTION_INSERT = 1;
	public static final int BATCH_ACTION_UPDATE = 2;
	public static final int BATCH_ACTION_DELETE = 3;
	
	@Autowired CompositionDao compositionDao;
	@Autowired private ComposeArrangerService composeArrangerService;
	
	@Override
	public int getCompositionCount() {
		return compositionDao.getCompositionCount();
	}

	@Override
	public Composition getCompositionByComposeNo(int composeNo) {
		return compositionDao.getCompositionByComposeNo(composeNo);
	}

	@Override
	public void insertComposition(Composition composition) {
		compositionDao.insertComposition(composition);
	}
	
	@Override
	public void updateComposition(Composition composition) {
		compositionDao.updateComposition(composition);
	}

	@Override
	public void deleteComposition(int composeNo) {
		compositionDao.deleteComposition(composeNo);
	}

	@Override
	public ArrayList<Composition> getCompositionList(int genreNo, 
			int pageCount,
			int pageOffset, int orderBy) {
		return compositionDao.getCompositionList(pageCount, pageOffset, orderBy);
	}

	@Override
	public ArrayList<CompositionCommand> getCompositionCommandList(int pageCount, int pageOffset, int orderBy) {
		return compositionDao.getCompositionCommandList(pageCount, pageOffset, orderBy);
	}

	@Override
	public CompositionCommand getCompositionCommandByComposeNo(int composeNo) {
		return compositionDao.getCompositionCommandByComposeNo(composeNo);
	}


	@Override
	public void updateCompositionUpdateCommand(ComposeUpdateCommand composeUpdateCommand) {
		
		CompositionCommand compositionCommand = composeUpdateCommand.getCompositionCommand();
		
		Composition composition = new Composition();
		composition =  composeUpdateCommand.getComposition();
		
		//ReflectionManager.reflectionCopy(compositionCommand, composition);
		System.out.println(">>>>>composition.getComposeRate::"+composition.getComposeRate());
		
		ArrayList<ComposeArrangeCommand> composeArrangeCommands = composeUpdateCommand.getComposeArrangeCommands();
		
		ArrayList<ComposeArranger> updateComposeArrangerList = new ArrayList<ComposeArranger>();
		ArrayList<ComposeArranger> insertComposeArrangerList = new ArrayList<ComposeArranger>();
		ArrayList<ComposeArranger> deleteComposeArrangerList = new ArrayList<ComposeArranger>();
		
		if (composition.getOpenStatus().equals("Y")){ //공개시 비공개작곡자 삭제처리
			this.composeArrangerService.deleteComposeArrangeByComposeNo(composition.getComposeNo());
		}
		
		ComposeArranger composeArranger = null;
		
		
		
		for (ComposeArrangeCommand composeArrangeCommand : composeArrangeCommands){
			composeArranger  = new ComposeArranger();
			ReflectionManager.reflectionCopy(composeArrangeCommand, composeArranger);
			
			int updateType = composeArrangeCommand.getUpdateType();
			
			System.out.println(">>>>>composeArranger.getArrangeMemberNo::"+composeArranger.getArrangeMemberNo());
			
			if (updateType == AppConstants.FormUpdateType.ACTION_TYPE_INSERT){
				/*
				 * 사용자는 실수나 부주의로 같은 보컬을 추가할 수 있기 때문에, 이미 기 등록된 사용자라면 new 일지라도 다시 insert 하지 
				 * 않는다. 무시하고 등록하는 경우 중복 키 문제 발생 
				 * 단 이런 경우라도 작성된 메시지가 있는 경우 메세지를 발송한다.
				*/
				ComposeArranger tempComposeArranger = composeArrangerService.getComposeArrangeByNo(compositionCommand.getComposeNo(), composeArranger.getArrangeMemberNo());
				if (tempComposeArranger == null){
					composeArranger.setComposeNo(composition.getComposeNo());
					insertComposeArrangerList.add(composeArranger);
				}
			}else if (updateType == AppConstants.FormUpdateType.ACTION_TYPE_UPDATE){
				updateComposeArrangerList.add(composeArranger);
			}else if (updateType == AppConstants.FormUpdateType.ACTION_TYPE_DELETE){
				deleteComposeArrangerList.add(composeArranger);
			}
		}
		
		this.composeArrangerBatch(insertComposeArrangerList, BATCH_ACTION_INSERT);
		this.composeArrangerBatch(updateComposeArrangerList, BATCH_ACTION_UPDATE);
		this.composeArrangerBatch(deleteComposeArrangerList, BATCH_ACTION_DELETE);
		
		this.updateComposition(composition);

		// 메시지가 존재하면 메시지를 발송한다.
		// 메시지 내용은 커맨드 객체의 message 프로퍼티로 세팅이 되며, ''  이 아닐 경우에 메시지를 발송한다.
		/*
		requestPerformanceMessage(arrangementCommand, performanceCommands);
		requestVocalMessage(arrangementCommand, composeArrangerCommands);*/
		
		//이후 updateType new , del 인 경우 해당 내용을 알려주는 시스템 자동 메세지를 발송하는 코드가 필요 
	
	}
	
	private void composeArrangerBatch(ArrayList<ComposeArranger> arrangeVocalList, int batchType){
		
		for (ComposeArranger composeArranger: arrangeVocalList){
			switch(batchType){
			case BATCH_ACTION_INSERT:
				this.composeArrangerService.insertComposeArranger(composeArranger);
				break;
			case BATCH_ACTION_UPDATE:
				this.composeArrangerService.updateComposeArrange(composeArranger);
				break;
			case BATCH_ACTION_DELETE:
				this.composeArrangerService.deleteComposeArrangerlByNo(composeArranger.getComposeNo(), composeArranger.getArrangeMemberNo());
				break;
			}
		}
	}


	@Override
	public ArrayList<ComposeArrangeCommand> getComposeArrangeCommandsByComposeNo(int composeNo) {
		return compositionDao.getComposeArrangeCommandsByComposeNo(composeNo);
	}

	
}
