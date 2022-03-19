package com.tdd.programmer;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.annotation.Profile;

import java.time.Duration;

import static com.tdd.programmer.StudyStatus.DRAFT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("beforeAll");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("afterAll");
//    }
//
//    @BeforeEach
//    void beforeEach() {
//        System.out.println("beforeEach");
//    }
//
//    @AfterEach
//    void afterEach() {
//        System.out.println("afterEach");
//    }

    @Test
    @Disabled
    void disabled() {
        System.out.println("disabled");
    }

    @Test
    @DisplayName("disPlayName 변경 😎")
    void create_new_study() {
        Study study = new Study(1);
        assertNotNull(study);
        assertEquals(DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 성태값은 "+  DRAFT + " 여야 한다.");
        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 합니다.");
    }

    @Test
    @DisplayName("assertAll test")
    void create1() {
        Study study = new Study(10);
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 성태값은 "+  DRAFT + " 여야 한다."),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 합니다.")
        );
    }

    @Test
    @DisplayName("throw exception test")
    void create2() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals("limit 은 0 보다 커야 합니다.", message);
    }

    @Test
    @DisplayName("assertTimeout test")
    void create3() {
        assertTimeout(Duration.ofMillis(1000), () ->{
            new Study(11);
            Thread.sleep(300);
        });
    }

    /**
     * 해당 테스트는 조심해서 사용해야 한다. 기대값을 넘어가면 멈추는데,
     * ThreadLocal 을 사용하는 구간의 테스트에서는 문재가 될 수 있다. ThreadLocal 은 쓰레드간의 공유를 하지 않기 때문에.
     */
    @Test
    @DisplayName("assertTimeoutPreemptively test")
    void create4() {
        assertTimeoutPreemptively(Duration.ofMillis(1000), () ->{
            new Study(11);
            Thread.sleep(300);
        });
    }


    @Test
    @DisplayName("assertj 라이브러리 의 assertThat test")
    void create5() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("조건에 따라 테스트를 실행한다.")
    void assumeTrueTest() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println("test_env = " + test_env);

        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Test
//    @EnabledOnOs({OS.MAC, OS.LINUX})
    @DisabledOnOs({OS.MAC, OS.LINUX})
    @DisplayName("profile 조건에 따라 테스트를 실행한다.")
    void osTest() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println("test_env = " + test_env);

        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }


    @Test
    @Tag("fast")
    @DisplayName("fast tag test")
    void fastTagTest() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
        System.out.println("fast tag");
    }

    @Test
    @Tag("slow")
    @DisplayName("slow tag test")
    void slowTagTest() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
        System.out.println("slow tag");
    }

    @Test
    @FastTest
    @DisplayName("fastTest annotaion test")
    void fastAnnotationTest() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
        System.out.println("fast annotation");
    }


    @DisplayName("반복테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("repetitionInfo = " + repetitionInfo);
    }

    @DisplayName("반복테스트+값 변경")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"반복적인", "테스트시", "여러가지", "parameter를", "정의합니다."})
    void parameterize(String message) {
        System.out.println(message);
    }


}