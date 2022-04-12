package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class BookAspect {

        private static Integer count = 0;

        @AfterReturning(pointcut =
                "execution(public * com.example.controller.BookController.save(..)) || " +
                        "execution(public * com.example.controller.BookController.delete(..)) ||" +
                        "execution(public * com.example.controller.BookController.borrow(..)) ||" +
                        "execution(public * com.example.controller.BookController.goList(..))")
        public void logChange(JoinPoint joinPoint){
            String methodName = joinPoint.getSignature().getName();
            String args = Arrays.toString(joinPoint.getArgs());
            count++;
            System.err.println("Method name: " + methodName);
            System.err.println("Args: " + args);
            System.err.println("Number of actions: " + count);
        }

        @AfterReturning(pointcut = "within(com.example.controller.*)")
        public void logAllChange(JoinPoint joinPoint){
            String methodName = joinPoint.getSignature().getName();
            String args = Arrays.toString(joinPoint.getArgs());
            count++;
            System.err.println("Method name: " + methodName);
            System.err.println("Args: " + args);
            System.err.println("Number of actions: " + count);
        }
}
