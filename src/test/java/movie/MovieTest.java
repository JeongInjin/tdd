package movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovieTest {
    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie();
    }

    @Test
    @DisplayName("그냥 만들때는 0을 반환해야 함")
    public void should_return_0_when_just_create() {
        Assertions.assertThat(movie.averageRating()).isEqualTo(0);
    }

    @Test
    @DisplayName("1을 rate 할경우 리턴값은 1이 나와야 함")
    public void should_return_1_when_1_was_rated() {
        movie.rate(1);
        Assertions.assertThat(movie.averageRating()).isEqualTo(1);
    }

    @Test
    @DisplayName("3, 5 rate 할경우 리턴값은 4가 나와야 함")
    public void should_return_4_when_3_and_5__were_rated() {
        movie.rate(3);
        movie.rate(5);
        Assertions.assertThat(movie.averageRating()).isEqualTo(4);
    }
}
