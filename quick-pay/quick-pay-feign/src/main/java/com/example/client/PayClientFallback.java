package com.example.client;

import com.example.common.base.ResultVO;
import com.example.common.enums.ResultEnum;
import com.example.common.exception.BusinessException;

public class PayClientFallback implements PayClient {

    @Override
    public ResultVO<String> testMethod() {
        throw new BusinessException(ResultEnum.FAILURE);
    }
}
