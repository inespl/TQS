package book;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookSearchSteps {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    //@ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")


    @Given("(a|another) book with the title {string}, written by {string} published in {int}-{int}-{int}")
    public void addNewBook(final String title, final String author, final int year, final int month, final int day) {
        System.out.println(title + author);
        Date published = new Date(year, month, day);
        Book book = new Book(title, author, published);
        library.addBook(book);
        library.showStore();
    }

    @When("the customer searches for books published between {int} and {int}")
    public void setSearchParameters(final Date from, final Date to) {
        result = library.findBooks(from, to);
    }

    @Then("{int} books should have been found")
    public void verifyAmountOfBooksFound(final int booksFound) {
        // assertThat(result.size(), is(booksFound));
        assertEquals(result.size(), booksFound);
    }

    @Then("Book {int} should have the title '{string}'")
    public void verifyBookAtPosition(final int position, final String title) {
        // assertThat(result.get(position - 1).getTitle()).isEqualTo(title);
        assertEquals(result.get(position - 1).getTitle(), title);
    }

    // nada funciona, não percebo
}
