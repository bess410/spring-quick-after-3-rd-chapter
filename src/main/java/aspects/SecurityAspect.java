package aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Log
@Component
@Order(1)
public class SecurityAspect {

    @Around(value = "@annotation(annotations.ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("Security Aspect: Calling the intercepted method");

        Object returnedValue = joinPoint.proceed();

        log.info("Security Aspect: Method executed and returned " + returnedValue);

        return returnedValue;
    }
}
