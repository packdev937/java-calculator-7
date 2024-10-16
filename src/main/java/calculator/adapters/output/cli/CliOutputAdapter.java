package calculator.adapters.output.cli;

import calculator.application.dto.response.CalculationResponse;
import calculator.application.dto.response.Response;
import calculator.port.output.OutputPort;

public class CliOutputAdapter implements OutputPort {

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void writeResponse(Response response) {
        if (response instanceof CalculationResponse) {
            CalculationResponse calculationResponse = (CalculationResponse) response;
            System.out.println("계산 결과: " + calculationResponse.result());
        } else {
            System.out.println(response.toString());
        }
    }
}
