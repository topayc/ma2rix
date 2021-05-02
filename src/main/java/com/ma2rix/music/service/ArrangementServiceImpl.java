package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.common.CommonUtils;
import com.ma2rix.music.dao.interfaces.ArrangementDao;
import com.ma2rix.music.manager.AppConstants;
import com.ma2rix.music.manager.ReflectionManager;
import com.ma2rix.music.model.command.ArrangeUpdateCommand;
import com.ma2rix.music.model.command.ArrangeVocalCommand;
import com.ma2rix.music.model.command.ArrangementCommand;
import com.ma2rix.music.model.command.CommentCommand;
import com.ma2rix.music.model.command.PerformanceCommand;
import com.ma2rix.music.model.domain.ArrangeVocal;
import com.ma2rix.music.model.domain.Arrangement;
import com.ma2rix.music.model.domain.Performance;
import com.ma2rix.music.service.interfaces.ArrangeVocalService;
import com.ma2rix.music.service.interfaces.ArrangementService;
import com.ma2rix.music.service.interfaces.MessageService;

@Service 
public class ArrangementServiceImpl implements ArrangementService {
	
	public static final int BATCH_ACTION_INSERT = 1;
	public static final int BATCH_ACTION_UPDATE = 2;
	public static final int BATCH_ACTION_DELETE = 3;
	
	@Autowired private MessageService messageService;
	@Autowired private ArrangementDao arrangementDao;
	@Autowired private ArrangeVocalService arrangeVocalService;
	
	@Override
	public void updateArrangeUpdateCommand(ArrangeUpdateCommand arrangeUpdateCommand) {
		ArrangementCommand arrangementCommand = arrangeUpdateCommand.getArrangeCommand();
		
		ArrayList<PerformanceCommand> performanceCommands = arrangeUpdateCommand.getPerformanceCommands();
		ArrayList<ArrangeVocalCommand> arrangeVocalCommands = arrangeUpdateCommand.getArrangeVocalCommands();
		
		ArrayList<Performance> updatePerformanceList = new ArrayList<Performance>();
		ArrayList<Performance> deletePerformanceList = new ArrayList<Performance>();
		ArrayList<Performance> insertPerformanceList = new ArrayList<Performance>();
	
		Arrangement arrangement = new Arrangement();
		ReflectionManager.reflectionCopy(arrangementCommand, arrangement);
		
		Performance performance = null;
		
		for(PerformanceCommand performanceCommand : performanceCommands){
			performance = new Performance();
			ReflectionManager.reflectionCopy(performanceCommand, performance);
			
			int updateType = performanceCommand.getUpdateType();
			
			if (updateType == AppConstants.FormUpdateType.ACTION_TYPE_INSERT){
				performance.initPerformance();
				performance.setArrangeNo(arrangement.getArrangeNo());
				insertPerformanceList.add(performance);
				
			}else if (updateType == AppConstants.FormUpdateType.ACTION_TYPE_UPDATE){
				updatePerformanceList.add(performance);
				
			}else if (updateType == AppConstants.FormUpdateType.ACTION_TYPE_DELETE){
				deletePerformanceList.add(performance);
			}
		}	
		ArrayList<ArrangeVocal> updateArrangeVocalList = new ArrayList<ArrangeVocal>();
		ArrayList<ArrangeVocal> insertArrangeVocalList = new ArrayList<ArrangeVocal>();
		ArrayList<ArrangeVocal> deleteArrangeVocalList = new ArrayList<ArrangeVocal>();
		
		
		ArrangeVocal arrangeVocal = null;
		for (ArrangeVocalCommand arrangeVocalCommand : arrangeVocalCommands){
			arrangeVocal  = new ArrangeVocal();
			ReflectionManager.reflectionCopy(arrangeVocalCommand, arrangeVocal);
			
			int updateType = arrangeVocalCommand.getUpdateType();
			
			if (updateType == AppConstants.FormUpdateType.ACTION_TYPE_INSERT){
				/*
				 * 사용자는 실수나 부주의로 같은 보컬을 추가할 수 있기 때문에, 이미 기 등록된 사용자라면 new 일지라도 다시 insert 하지 
				 * 않는다. 무시하고 등록하는 경우 중복 키 문제 발생 
				 * 단 이런 경우라도 작성된 메시지가 있는 경우 메세지를 발송한다.
				*/
				ArrangeVocal tempArrangeVocal = arrangeVocalService.
						getArrangeVocalByArrangeNoAndVocalMemberNo(arrangement.getArrangeNo(), arrangeVocal.getVocalMemberNo());
				if (tempArrangeVocal == null){
					arrangeVocal.setArrangeNo(arrangement.getArrangeNo());
					insertArrangeVocalList.add(arrangeVocal);
				}
			}else if (updateType == AppConstants.FormUpdateType.ACTION_TYPE_UPDATE){
				updateArrangeVocalList.add(arrangeVocal);
			}else if (updateType == AppConstants.FormUpdateType.ACTION_TYPE_DELETE){
				deleteArrangeVocalList.add(arrangeVocal);
			}
		}
		
		this.updateArrangement(arrangement);
		this.performanceBatch(insertPerformanceList,BATCH_ACTION_INSERT);
		this.performanceBatch(updatePerformanceList,BATCH_ACTION_UPDATE);
		this.performanceBatch(deletePerformanceList,BATCH_ACTION_DELETE);
		
		this.arrangeVocalBatch(insertArrangeVocalList,BATCH_ACTION_INSERT);
		this.arrangeVocalBatch(updateArrangeVocalList, BATCH_ACTION_UPDATE);
		this.arrangeVocalBatch(deleteArrangeVocalList, BATCH_ACTION_DELETE);
		
		// 메시지가 존재하면 메시지를 발송한다.
		// 메시지 내용은 커맨드 객체의 message 프로퍼티로 세팅이 되며, ''  이 아닐 경우에 메시지를 발송한다.
		/*
		requestPerformanceMessage(arrangementCommand, performanceCommands);
		requestVocalMessage(arrangementCommand, arrangeVocalCommands);*/
		
		//이후 updateType new , del 인 경우 해당 내용을 알려주는 시스템 자동 메세지를 발송하는 코드가 필요 
	}
	
	private void requestPerformanceMessage(ArrangementCommand aCommand,
			ArrayList<PerformanceCommand> performanceCommands) {
		for (PerformanceCommand pCommand : performanceCommands){
			if  (pCommand.getMessageContent() == null || "".equals(pCommand.getMessageContent())) continue;
			messageService.sendCommonMessage(0,aCommand.getArrangeMemberNo(),pCommand.getPerformMemberNo(),AppConstants.TransferType.SEND,
					pCommand.getMessageType(),aCommand.getArrangeNo(),pCommand.getMessageContent(),AppConstants.MessageReadStatus.NOT_READ);
		}
	}

	private void requestVocalMessage(ArrangementCommand aCommand,
			ArrayList<ArrangeVocalCommand> avCommands) {
		
		for (ArrangeVocalCommand avCommand : avCommands){
			if (!CommonUtils.isNullOrEmpty(avCommand.getMessageContent())){
				messageService.sendCommonMessage(0,aCommand.getArrangeMemberNo(),avCommand.getVocalMemberNo(),AppConstants.TransferType.SEND,
						avCommand.getMessageType(),aCommand.getArrangeNo(),avCommand.getMessageContent(),AppConstants.MessageReadStatus.NOT_READ);
			}
		}
	}

	private void performanceBatch(ArrayList<Performance> performanceList, int batchType){
		for (Performance performance : performanceList){
			switch(batchType){
			case BATCH_ACTION_INSERT:
				this.insertPerformance(performance);
				break;
			case BATCH_ACTION_UPDATE:
				this.updatePerformance(performance);
				break;
			case BATCH_ACTION_DELETE:
				this.deletePerformance(performance);
				break;
			}
		}
	}
	
	private void arrangeVocalBatch(ArrayList<ArrangeVocal> arrangeVocalList, int batchType){
		for (ArrangeVocal arrangeVocal: arrangeVocalList){
			switch(batchType){
			case BATCH_ACTION_INSERT:
				this.arrangeVocalService.insertArrangeVocal(arrangeVocal);
				break;
			case BATCH_ACTION_UPDATE:
				this.arrangeVocalService.updateArrangeVocal(arrangeVocal);
				break;
			case BATCH_ACTION_DELETE:
				this.arrangeVocalService.
					deleteArrangeVocalByArrangeNoAndVocalMemberNo(arrangeVocal.getArrangeNo(), arrangeVocal.getVocalMemberNo());
				break;
			}
		}
	}
	
	@Override
	public ArrayList<ArrangementCommand> getArrangementCommandList(int genreNo,
			int pageCount, int pageOffset, int orderBy, String arrangeStatus) {
		return arrangementDao.getArrangementCommandList(genreNo, pageCount, pageOffset, orderBy, arrangeStatus);
	}
	

	@Override
	public ArrayList<CommentCommand> getCommentCommandList(String musicClassNo,
			int pageCount, int pageOffset, int orderBy) {
		return arrangementDao.getCommentCommandList(musicClassNo, pageCount, pageOffset, orderBy);
	}	
	
	
	
	@Override
	public int getArrangementCount() {
		return arrangementDao.getArrangementCount();
	}

	@Override
	public ArrangementCommand getArrangementCommandByArrangeNo(int arrangeNo) {
		return arrangementDao.getArrangementCommandByArrangeNo(arrangeNo);
	}

	@Override
	public void insertArrangement(Arrangement arrangement) {
		arrangementDao.insertArrangement(arrangement);
	}

	@Override
	public void updateArrangement(Arrangement arrangement) {
		arrangementDao.updateArrangement(arrangement);
	}

	@Override
	public void deleteArrangement(int arrangeNo) {
		arrangementDao.deleteArrangement(arrangeNo);
	}

	@Override
	public ArrayList<Performance> getPerformancesByArrangeNo(int arrangeNo) {
		return arrangementDao.getPerformancesByArrangeNo(arrangeNo);
	}

	@Override
	public void insertPerformance(Performance performance) {
		arrangementDao.insertPerformance(performance);
	}

	@Override
	public void updatePerformance(Performance performance) {
		arrangementDao.updatePerformance(performance);
	}

	@Override
	public void deletePerformance(Performance performance) {
		arrangementDao.deletePerformance(performance);
	}

	@Override
	public Arrangement getArrangementByArrangeNo(int arrangeNo) {
		return arrangementDao.getArrangementByArrangeNo(arrangeNo);
	}

	@Override
	public ArrayList<ArrangementCommand> getAllArrangementCommandList() {
		
		return arrangementDao.getAllArrangementCommandList();
	}

	@Override
	public void addComment(int arrangeNo, int memberNo, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<PerformanceCommand> getPerformanceCommandsByArrangeNo(
			int arrangeNo) {
		return arrangementDao.getPerformanceCommandsByArrangeNo(arrangeNo);
	}




}
