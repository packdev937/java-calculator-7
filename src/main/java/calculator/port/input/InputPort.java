package calculator.port.input;

import calculator.application.dto.request.Request;

public interface InputPort<T extends Request> {

    T readRequest();
}

/**
 * "입력 어댑터가 CLI 입력을 처리하여 입력 포트에 직접 전달할 수 있다" 라는 건
 * <p>
 * 입력 어댑터는 데이터 입력을 받아서 이 입력을 포트를 통해 애플리케이션의 유즈케이스에 전달
 * <p>
 * InputPort는 외부에서 들어오는 데이터를 받아들이기 위한 "관문"
 */