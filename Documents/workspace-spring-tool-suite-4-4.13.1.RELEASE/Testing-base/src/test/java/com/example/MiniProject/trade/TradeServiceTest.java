package com.example.MiniProject.trade;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.junit.jupiter.api.Test;

class TradeServiceTest {
	
	 @Spy
	    private TradeService trService = new TradeService();

	    @InjectMocks
	    private TradeService mkTrService;

	    @Mock
	    private RegionalDao regDao;

	    @Mock
	    private RegionalDaoManager regDaoManager;


	    @Mock
	    private TradeDetails trdDetails;

	@Test
	void testGetTradeDetails() throws SQLException {
		Mockito.when(regDaoManager.getRegionalDao(Region.TOKYO)).thenReturn(new TokyoDao());
        Mockito.when(regDao.getDataSource().getConnection()).thenReturn(Mockito.any());


        Mockito.when(regDao.getTradeDetails(12232140)).thenReturn(new TradeDetails());
        Mockito.when(mkTrService.getTradeDetails(12232140)).thenReturn(new TradeDetails());


        TradeDetails tradeDetails = mkTrService.getTradeDetails(12345678);
        TradeDetails expectedTradeDetails = new TradeDetails();
        expectedTradeDetails.setTradeId(12232140);
        expectedTradeDetails.setStatus(0);
        expectedTradeDetails.setRegion(Region.NEWYORK);

        assertEquals(expectedTradeDetails,tradeDetails);

	}

}
