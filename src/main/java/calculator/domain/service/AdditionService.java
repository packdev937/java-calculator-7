package calculator.domain.service;

import calculator.application.dto.request.CalculationRequest;
import calculator.application.dto.response.CalculationResponse;
import calculator.domain.vo.delimiter.Delimiters;

import calculator.domain.vo.number.Numbers;

public class AdditionService {

    public CalculationResponse compute(final CalculationRequest calculationRequest) {
        String input = calculationRequest.input();

        Delimiters delimiters = Delimiters.from(input);
        Numbers numbers = delimiters.extractNumbers(input);

        return new CalculationResponse(numbers.reduce());
    }
}

/**
 * 도메인 서비스에 관한 고찰.
 * <p>
 * 헥사고날 아키텍쳐 관점에서 도메인 서비스를 사용하고 안하고의 차이 (1) 도메인 서비스를 사용하지 않는 경우 CalculateStringCommand 클래스에서 직접
 * Delimiters, Numbers 클래스를 사용하여 계산한다. CalculateStringCommand 클래스가 여러 책임을 맡게된다.
 * <p>
 * (2) 도메인 서비스를 사용하는 경우 CalculateStringCommand 클래스에서 AdditionService를 사용하여 계산한다.
 * CalculateStringCommand는 단지 입력을 받고, 비즈니스 로직을 호출하고, 결과를 출력하는 역할을 담당한다. 테스트가 용이하다.
 * <p>
 * UseCase는 비즈니스 로직을 위임하는 역할에 집중하는 것이 좋으므로 도메인 서비스를 사용하는 것이 바람직하다.
 * <p>
 * 도메인 서비스와 도메인의 관계 여러 도메인 객체가 상호작용해야 할 때, 그 상호작용을 처리하고 조율하는 역할을 합니다. 위의 예제에서는 Numbers와 Delimiters
 * 객체가 상호작용해야 하는데, AdditionService가 이를 처리하고 조율한다.
 * <p>
 * 반면 도메인은 비즈니스 로직을 캡슐화 하는 핵심 요소이다. 한 도메인 내에서 일어나는 주요 로직을 처리한다. 스스로 처리할 수 있는 책임을 갖는다.
 * <p>
 * <p>
 * 만약에 도메인에 대한 복잡한 초기화 과정이 필요하다면 Factory 클래스도 고민하자. 예를 들어, Delimiter 도메인에 DelimiterParser,
 * DelimiterValidator 등 여러 클래스가 필요하다면 Factory로 의존성을 주입하고 이를 통해 create 혹은 extractDelimiters 등 다양한
 * 메소드를 처리하자. (Factory Method 패턴)
 * <p>
 * 도메인 서비스가 처리해야 되는가 유스케이스가 처리해야되는가 이는 흐름을 볼 필요가 있다. 만약 여러 객체를 사용하여 전체 작업을 처리하는 흐름이라면 UseCase가 처리한다.
 * 주로 도메인 간의 협력 (흐름) 이라면 도메인 서비스가 관리한다.
 */