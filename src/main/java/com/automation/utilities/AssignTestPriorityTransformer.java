package com.automation.utilities;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javassist.*;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AssignTestPriorityTransformer implements IAnnotationTransformer
{
    static ClassPool s_ClassPool = ClassPool.getDefault(); 

    public void transform(ITestAnnotation p_annotation, Class p_testClass, Constructor p_testConstructor, Method p_testMethod)
    {
        p_annotation.setPriority(getMethodLineNumber(p_testMethod));
    }
    private int getMethodLineNumber(Method p_testMethod)
    {
        try
        {
            CtClass cc = s_ClassPool.get(p_testMethod.getDeclaringClass().getCanonicalName());
            CtMethod methodX = cc.getDeclaredMethod(p_testMethod.getName());
            return methodX.getMethodInfo().getLineNumber(0);        
        }
        catch(Exception e)
        {
            throw new RuntimeException("Getting of line number of method "+p_testMethod+" failed", e);
        }
    }
}