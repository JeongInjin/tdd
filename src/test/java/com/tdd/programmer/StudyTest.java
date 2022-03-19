package com.tdd.programmer;

import org.junit.jupiter.api.*;

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
    void create_new_study() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    @DisplayName("disPlayName 변경 😎")
    void create1() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create2");
    }

    @Test
    void create2() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create3");
    }

}