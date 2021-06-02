package jim.app.test;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
@Transactional
public class InitialSetup {	

	@EventListener 
	@Transactional 
	public void onApplicationEvent(ApplicationReadyEvent event) { 	
		System.out.println("--------------System Initiliaze-----------------");
		
		
	}
	
	

}
