## 기능 명세서 
> 구분자와 숫자로 구성된 문자열을 입력받는 덧셈 계산기를 구현한다.

## 요구 사항 
### 입력
- [x] 문자열을 입력한다
  - [x] 정상적인 입력이 아닐 시 `IllegalArguementException`을 발생한다
  - [x] 문자열 앞 뒤 공백 존재 시 예외를 발생한다 
  - [x] 문자열이 비어있을 시 예외를 발생한다
  - [x] 문자열의 끝 값이 숫자가 아닌 다른 값이라면 예외를 발생한다
  - [x] 문자열의 `//`와 `\n` 사이에 단어가 아닌 문자열이 주어지면 예외를 발생한다
  - [x] 문자열의 숫자 앞에 음수 기호가 있을 시 예외를 발생한다
  - [x] 구분자가 두 개 이상 연속 되어 있을 시 예외를 발생한다
- [x] 문자열은 구분자와 양수로 구성된다
- [x] 음수를 입력되면 `IllegalArguementException`을 발생한다

### 출력
- [x] 덧셈 결과를 출력한다
- [x] `결과 : [숫자]` 형식으로 출력한다

### 동작 
- [x] 커스텀 구분자를 인식한다
  - [x] `//`와 `\n` 로 감싸진 문자열을 구분자로 추가한다
  - [x] 등록되지 않은 커스텀 구분자 발견 시 `IllegalArgumentException`을 발생한다
  - [x] 구분자를 `Delimiter` 타입으로 변환한다
- [x] 숫자를 구분한다
  - [x] 기본 구분자 `,`,`:` 와 커스텀 구분자로 숫자를 구분한다.
  - [x] 숫자를 `Number` 타입으로 변환한다.
- [x] 숫자를 더한다

### 기타 
- [x] `camp.nextstep.edu.missionutils.Console의 readLine()`을 활용한다
- [x] 에러 메세지를 상수화 하여 관리한다 

### 체크리스트 
- [x] DIP 원칙을 준수했는가
- [x] 디미터 법칙을 준수했는가
- [x] YAGNI를 준수했는가
- [x] DRY 원칙을 준수했는가
- [x] KISS 원칙을 준수했는가

## 실행 결과 예시
```java
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```