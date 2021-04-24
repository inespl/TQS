package book;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.MatcherAssert.*;

public class BookSearchSteps {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return textToDate(year, month, day);
    }

    @Given("(a|another) book with the title {string}, written by {string} published in {iso8601Date}")
    public void addNewBook(final String title, final String author, final LocalDateTime published) {
        Book book = new Book(title, author, published);
        library.addBook(book);
    }

    @When("the customer searches for books published between (\\d+) and (\\d+)")
    public void setSearchParameters(final LocalDateTime from, final LocalDateTime to) {
        result = library.findBooks(from, to);
    }

    @Then("{int} books should have been found")
    public void verifyAmountOfBooksFound(final int booksFound) {
        assertThat(result.size(), is(booksFound));
    }

    @Then("Book (\\d+) should have the title '(.+)'")
    public void verifyBookAtPosition(final int position, final String title) {
        assertThat(result.get(position -1).getTitle(), equalTo(title));

        assertThat(result.get(position - 1).getTitle()).isEqualTo(title);
    }
}
