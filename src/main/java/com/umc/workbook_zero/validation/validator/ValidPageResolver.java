package com.umc.workbook_zero.validation.validator;

import com.umc.workbook_zero.apiPayload.code.status.ErrorStatus;
import com.umc.workbook_zero.apiPayload.exception.PageException;
import com.umc.workbook_zero.validation.annotation.ValidPage;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class ValidPageResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidPage.class) && parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String pageParam = webRequest.getParameter("page");
        int page = 0;
        try {
            page = Integer.parseInt(pageParam);
            if (page < 1) throw new PageException(ErrorStatus.PAGE_INVALID);
        } catch (NumberFormatException e) {
            throw new PageException(ErrorStatus.PAGE_INVALID);
        }
        return page - 1; // 1-based to 0-based
    }
}