package jim.app.test.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import jim.app.test.dto.PostDto;
import jim.app.test.helper.CustomHelper;
import jim.app.test.model.request.FirstTestModelRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Component
@EnableAspectJAutoProxy(proxyTargetClass=true)
@Aspect
@Log4j2
public class PostAspect {
	
	private CustomHelper helper;
	
	@AfterReturning(pointcut="execution(public * jim.app.test.service.implementation.PostServiceImplementation.firstEndpoint(..))",returning="retVal")
    public void afterSearching(JoinPoint pjp,List retVal) throws Throwable {		
		List<PostDto> list = retVal;
		/*
		 * for(PostDto dto: list ) {
		 * log.info(".......................Log First Test......................."+dto.
		 * toString()); }
		 */
		//helper.addupdateSearchLog(list);
		
    }
	
	@Before("execution(public * jim.app.test.service.implementation.PostServiceImplementation.firstEndpoint(..)) && args(ascending,request,..)")
    public void checkGetSaveIssueLog(JoinPoint pjp,Boolean ascending, FirstTestModelRequest request) throws Throwable {
		
		/*
		 * for(String keyword: request.getKeywords()) {
		 * log.info(".......................Log First Test......................."
		 * +keyword); }
		 */
		helper.addupdateSearchLog(request.getKeywords());
	}
}
