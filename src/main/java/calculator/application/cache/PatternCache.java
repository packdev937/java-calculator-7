package calculator.application.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class PatternCache {

    private static ConcurrentHashMap<String, Pattern> cache = new ConcurrentHashMap<>();

    public static Pattern getPattern(String regex) {
        return cache.computeIfAbsent(regex, Pattern::compile);
    }
}

/**
 * 헥사고날 아키텍쳐의 패키지는 정해진 규격이 없는 것이 특징
 * <p>
 * 외부와의 상호작용 (데이터를 빠르게 반환) 하는 캐싱이었다면 output adapter에 위치하는게 맞지만 값비싼 객체인 Pattern은 캐싱하고 내부 도메인 로직이 빠르게
 * 객체를 참조할 수 있도록 하기 위한 캐시이므로 Application에 위치하는게 맞음
 * <p>
 * utility 혹은 cache 혹은 helper 패키지에 위치할 수 있음
 *
 * Effective Java Item 6 : 불필요한 객체 생성을 피하라
 */