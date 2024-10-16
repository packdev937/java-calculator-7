package calculator.port.output;

import calculator.application.dto.response.Response;

public interface OutputPort<T extends Response> {

    void writeMessage(String message);

    void writeResponse(T response);
}

/**
 * OutputPort는 내부에서 발생한 데이터를 외부로 출력하기 위한 "관문"
 */
