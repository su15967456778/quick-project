package com.example.client;

import com.example.quickcommon.base.ResultVO;
import com.example.quickcommon.enums.ResultEnum;
import com.example.quickcommon.exception.BusinessException;

public class BusinessClientFallback implements BusinessClient {

    @Override
    public ResultVO<String> testMethod() {
        throw new BusinessException(ResultEnum.FAILURE);
    }
}
