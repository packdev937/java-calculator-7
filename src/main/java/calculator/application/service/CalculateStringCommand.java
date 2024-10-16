package calculator.application.service;

import static calculator.infrastructure.constants.ResponseMessage.REQUEST_INPUT_MESSAGE;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.response.CalculationResponse;
import calculator.domain.service.AdditionService;
import calculator.port.input.InputPort;
import calculator.port.output.OutputPort;
import calculator.application.usecase.CalculateStringUseCase;
import calculator.application.validation.InputValidator;

public class CalculateStringCommand implements CalculateStringUseCase {

    private AdditionService additionService;
    private InputValidator inputValidator;
    private InputPort<CalculationRequest> inputPort;
    private OutputPort<CalculationResponse> outputPort;

    public CalculateStringCommand(InputPort inputPort, OutputPort outputPort,
        InputValidator inputValidator, AdditionService additionService) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
        this.inputValidator = inputValidator;
        this.additionService = additionService;
    }

    @Override
    public void calculate() {
        outputPort.writeMessage(REQUEST_INPUT_MESSAGE.getMessage());
        CalculationRequest request = inputPort.readRequest();

        inputValidator.validate(request);
        CalculationResponse response = additionService.compute(request);

        outputPort.writeResponse(response);
    }
}

/**
 * 어떤 경우에 Validator를 분리하고 어떤 경우에는 분리하지 않는가
 * <p>
 * (1) Validator를 분리하는 경우 검증 로직이 매우 복잡하거나 외부 서비스와의 상호작용이 필요한 경우 별도의 Validator 서비스 (의존성 주입도 가능하니) 으로
 * 분리하고 처리한다
 * <p>
 * (2) Validator를 분리하지 않는 경우 간단한 도메인 규칙은 도메인 내부에서 처리하는 것이 더 적절할 수 있다.
 * <p>
 * 예를 들어, Number 클래스에서 Number의 범위를 검증하는 로직은 Number 클래스 내부에 위치하는 것이 더 적절하다. Delimiter 클래스에서 한 단어로
 * 구분자가 이뤄지는지 검증하는 것이 더 적절하다.
 * <p>
 * Controller 대신 UseCase가 흐름을 관리하는 이유 우선 Controller는 다르게 말해 WebAdapter (CliAdapter와 동일한) 로서 외부의 입력
 * (API 요청) 을 내부로 전달하는 구현체 역할 Input Port는 입력을 검증하고 유즈케이스에 전달하는 역할. 따라서, Cli 환경에서 별도의 Controller가
 * 필요없음
 * <p>
 * readLine() 보다 요청을 받고 해당 요청을 유즈케이스에 전달하는 느낌으로, Cli 대신 HTTP 명령이 와도 수행할 수 있는 느낌으로 변경했고 결과는 다음과 같다.
 * CalculationRequest request = inputPort.readRequest();
 */