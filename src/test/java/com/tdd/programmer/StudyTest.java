package com.tdd.programmer;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.tdd.programmer.StudyStatus.DRAFT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

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





}