package cn.rumofuture.nemo.util.injector;

import cn.rumofuture.nemo.domain.dto.ResponseEntity;

public class DataInject<T> {

    public ResponseEntity<T> responseEntity(boolean successOrNot, String message, T data) {
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        if (successOrNot)
            responseEntity.setCode(ResponseEntity.SUCCESS);
        else
            responseEntity.setCode(ResponseEntity.FAILED);
        responseEntity.setMessage(message);
        responseEntity.setData(data);
        return responseEntity;
    }
}
