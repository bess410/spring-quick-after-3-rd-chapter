package aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Log
@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Around(value = "@annotation(annotations.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("Logging Aspect: Calling the intercepted method");

        Object returnedValue = joinPoint.proceed();

        log.info("Logging Aspect: Method executed and returned " + returnedValue);

        return returnedValue;
    }
}
