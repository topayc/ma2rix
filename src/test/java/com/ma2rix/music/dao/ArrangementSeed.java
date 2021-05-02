package com.ma2rix.music.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ma2rix.music.dao.interfaces.ArrangementDao;
import com.ma2rix.music.dao.interfaces.CompositionDao;
import com.ma2rix.music.model.domain.Arrangement;
import com.ma2rix.music.model.domain.AttachMusic;
import com.ma2rix.music.model.domain.Composition;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
})
public class ArrangementSeed {
	
	@Autowired ArrangementDao arrangementDao;
	@Autowired CompositionDao compositionDao;
	
	@Test
	public void prepareArrangeSeeds() {
		Composition com = new Composition();
		com.setComposeMemberNo(1);
		com.setComposeTitle("사랑하는 당신");
		com.setOpenStatus("Y");
		com.setComposeRate((float)30.0);
		com.setComposeMemo("good");
		com.setSalePrice((float)10);
		com.setChargeStatus("Y");
		com.setComposeStatus("02");
		com.setSaleStatus("02");
		com.setModAdminNo(1);
		compositionDao.insertComposition(com);
		
		for (int i = 0; i < 50; i++){
			Arrangement arrangement = new Arrangement();
			arrangement.setComposeNo(com.getComposeNo());
			arrangement.setArrangeMemberNo(1);
			arrangement.setArrangeTitle("ma2_001" + String.valueOf(i));
			arrangement.setGenreNo(1);
			arrangement.setOpenStatus("Y");
			arrangement.setComposeRate((float)30.0);
			arrangement.setArrangeRate((float)30.0);
			arrangement.setArrangeMemo("good arrangement_ " + String.valueOf(i));
			arrangement.setLimitCount(0);
			arrangement.setSalePrice((float)10.0);
			arrangement.setLimitStatus("N");
			arrangement.setChargeStatus("Y");
			arrangement.setArrangeStatus("02");
			arrangement.setSaleStatus("02");
			arrangement.setModAdminNo(1);
			arrangementDao.insertArrangement(arrangement);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Test 
	public void testArrangement(){
		
	}
}
