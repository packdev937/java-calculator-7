package calculator.application.dto.response;

import static calculator.infrastructure.exception.ErrorCode.*;

import java.math.BigInteger;

public record CalculationResponse(BigInteger result) implements Response {

    public CalculationResponse {
        if (result == null) {
            throw new IllegalArgumentException(RESULT_IS_NULL.getMessage());
        }
    }

    @Override
    public String toString() {
        return "계산 결과: " + result;
    }

}
