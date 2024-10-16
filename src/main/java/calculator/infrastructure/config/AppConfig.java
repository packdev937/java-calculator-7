package calculator.infrastructure.config;

import calculator.domain.service.AdditionService;
import calculator.port.input.InputPort;
import calculator.adapters.input.cli.CliInputAdapter;
import calculator.port.output.OutputPort;
import calculator.adapters.output.cli.CliOutputAdapter;
import calculator.application.service.CalculateStringCommand;
import calculator.application.usecase.CalculateStringUseCase;
import calculator.application.validation.InputValidator;

public class AppConfig {

    private InputPort inputPort;
    private OutputPort outputPort;
    private InputValidator inputValidator;
    private CalculateStringUseCase calculateStringUseCase;
    private AdditionService additionService;

    public AppConfig() {
        this.inputPort = new CliInputAdapter();
        this.outputPort = new CliOutputAdapter();
        this.inputValidator = new InputValidator();
        this.additionService = new AdditionService();
        this.calculateStringUseCase = new CalculateStringCommand(inputPort, outputPort,
            inputValidator, additionService);
    }

    public CalculateStringUseCase getCalculateStringUseCase() {
        return calculateStringUseCase;
    }
}

/**
 * 모든 객체를 생성하고 의존성을 주입하는 AppConfig 클래스
 */
