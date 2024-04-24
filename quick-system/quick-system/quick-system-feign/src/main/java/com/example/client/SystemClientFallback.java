package com.example.client;

import com.example.quickcommon.base.ResultVO;
import com.example.quickcommon.enums.ResultEnum;
import com.example.quickcommon.exception.BusinessException;

public class SystemClientFallback implements SystemClient {

    @Override
    public ResultVO<String> testMethod() {
        throw new BusinessException(ResultEnum.FAILURE);
    }
}
