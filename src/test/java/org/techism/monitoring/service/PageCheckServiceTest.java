package org.techism.monitoring.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.techism.monitoring.domain.PageCheck;
import org.techism.monitoring.domain.PageCheckRepository;

@RunWith(MockitoJUnitRunner.class) 
public class PageCheckServiceTest {
	
	private static PageCheckRepository repository;
	
	@Before
	public void setUp (){
		 repository = mock(PageCheckRepository.class);
		 // TODO findAll
	}
	
	@Test
	public void getStatus(){
		PageCheckService service = new PageCheckService();
		service.repository = repository;
		List<PageCheck> result = service.getStatus();
		
		assertEquals(0, result.size());
		verify(repository, times(1)).findAll();
	}
	
	@Test
	public void check(){
		PageCheckService service = new PageCheckService();
		service.repository = repository;
		String result = service.check();
		
		assertEquals("done", result);
		verify(repository, times(1)).findAll();
	}

}
