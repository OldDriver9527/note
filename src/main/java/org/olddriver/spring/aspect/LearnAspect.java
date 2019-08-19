package org.olddriver.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LearnAspect {
	
	@DeclareParents(value="org.olddriver.spring.bean.ExampleBean", defaultImpl=DefaultUsageTracked.class)
    public static UsageTracked mixin;

	
	@Pointcut("execution(* org.olddriver.spring.bean.ExampleBean.*(..))")// the pointcut expression
	private void pointcut() {}// the pointcut signature
	
	@Before("pointcut()")
    public void beforeAdvice() {
        System.out.println("beforeAdvice");
    }
}
