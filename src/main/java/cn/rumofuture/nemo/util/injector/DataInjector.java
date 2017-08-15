package cn.rumofuture.nemo.util.injector;

import cn.rumofuture.nemo.domain.dto.ResponseEntity;

public class DataInjector {

    public static ResponseEntity responseEntityInjector(boolean successOrNot, String message, Object data) {
        ResponseEntity responseEntity = new ResponseEntity();
        if (successOrNot)
            responseEntity.setCode(ResponseEntity.SUCCESS);
        else
            responseEntity.setCode(ResponseEntity.FAILED);
        responseEntity.setMessage(message);
        responseEntity.setData(data);
        return responseEntity;
    }
}
