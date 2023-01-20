package com.example.BookAuthor.Service;

import com.example.BookAuthor.Convertors.AuthorConvertor;
import com.example.BookAuthor.Convertors.BookConvertor;
import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Models.Book;
import com.example.BookAuthor.Repository.AuthorRepository;
import com.example.BookAuthor.Repository.BookRepository;
import com.example.BookAuthor.RequestDto.BookRequestDto;
import com.example.BookAuthor.ResponseDto.AuthorResponseDto;
import com.example.BookAuthor.ResponseDto.BookResponseDto;
import com.example.BookAuthor.Updates.UpdateBookPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String createBook(BookRequestDto bookRequestDto){
        Book book = BookConvertor.convertDtoToEntity(bookRequestDto);
        //I need to set the AuthorEntity :
        int authorId = bookRequestDto.getAuthorId();
        //Getting the author Entity
        Author author  = authorRepository.findById(authorId).get();
        book.setAuthor(author);
        //That book list also needs to be updated
        List<Book> currentListOfBooks = author.getBooksWritten();
        currentListOfBooks.add(book);
        author.setBooksWritten(currentListOfBooks);
        //Save the author
        authorRepository.save(author);
        //Save the book
        //This function will automatically be called by the parent save
        return "successfully added book";
    }

//    public Book findBookByName(String name){
//      Book book = bookRepository.findByName(name);
//      return book;
//    }
    public BookResponseDto getBookById(int id){
        BookResponseDto bookResponseDto = new BookResponseDto();
        Book book = bookRepository.findById(id).get();
        bookResponseDto.setName(book.getName());
        bookResponseDto.setGenre(book.getGenre());
        bookResponseDto.setPages(book.getPages());
        bookResponseDto.setAuthorName(book.getAuthor().getName());

        return bookResponseDto;
    }

    public void updateBookPages(UpdateBookPages updateBookPages){
        int id = updateBookPages.getId();
        Book bookToBeUpdated = bookRepository.findById(id).get();
        bookToBeUpdated.setPages(updateBookPages.getPages());
        bookRepository.save(bookToBeUpdated);
    }


    public void deleteBookById(Integer id){
        bookRepository.deleteById(id);
    }

}