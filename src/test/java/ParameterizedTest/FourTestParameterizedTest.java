package ParameterizedTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FourTestParameterizedTest {

    static Stream<Arguments> dataProvider1() {
        return Stream.of(
                Arguments.of("Фантастика", "Три дня Индиго", "Сергей Лукьяненко"),
                Arguments.of("Детективы","Судьба по книге перемен", "Татьяна Устинова")
        );
    }
    @MethodSource("dataProvider1")
    @ParameterizedTest(name = "Checking The author's book title")
    public void checkingBookstore(String genre, String nameBook, String author) {
        open("https://www.litres.ru/");
        $x("//div[@class='LowerMenu-module__item LowerMenu-module__genres']/a[text()='Жанры']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        $x("//a[text()='"+genre+"']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        $("img[alt='"+nameBook+"']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        $("button[rel='#buy_book_data']").shouldBe(Condition.visible, Duration.ofSeconds(30));
        $("a.biblio_book_author__link span").shouldHave(Condition.text(author));
    }
}
