package calculator.infrastructure.constants;

public enum ResponseMessage {
    REQUEST_INPUT_MESSAGE("덧셈할 문자열을 입력해주세요.");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

/**
 * 애플리케이션 전반적인 동작과 관련된 상수들은 Infrastructure 계층에 위치한다.
 * 출력 문구, 입력 문구 등이 해당한다.
 */