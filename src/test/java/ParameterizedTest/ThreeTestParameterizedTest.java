package ParameterizedTest;

import Data.Books;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ThreeTestParameterizedTest {

    @EnumSource(Books.class)
    @ParameterizedTest()
    public void checkingBookstore(Books book) {
        open("https://www.litres.ru/");
        $x("//div[@class='LowerMenu-module__item LowerMenu-module__genres']/a[text()='Жанры']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        $x("//a[text()='" + book + "']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
    }
}
