package jim.app.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import jim.app.test.helper.CustomHelper;
import jim.app.test.model.request.FirstTestModelRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
@EnableAspectJAutoProxy(proxyTargetClass=true)
@Aspect

public class PostAspect {	
	private CustomHelper helper;	
	
	@Before("execution(public * jim.app.test.service.implementation.PostServiceImplementation.firstEndpoint(..)) && args(ascending,request,..)")
    public void checkGetSaveIssueLog(JoinPoint pjp,Boolean ascending, FirstTestModelRequest request) throws Throwable {
		
		helper.addupdateSearchLog(request.getKeywords());
	}
}
