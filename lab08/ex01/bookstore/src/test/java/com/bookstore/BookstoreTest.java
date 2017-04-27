package com.bookstore;

import mockit.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import com.bookstore.service.BookstoreServiceImpl;
import com.bookstore.domain.SearchCriteria;
import com.bookstore.domain.Book;
import com.bookstore.exception.CannotProcessRequestException;
import com.bookstore.exception.ServiceUnavailableException;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Test
public class BookstoreTest {
    @Mocked
    private BookstoreServiceImpl service;
    
    @Test
    public void addSucessful() throws Throwable{
		final Book book = new Book("Lúsiadas", new BigDecimal(10), "Luís Vaz de Camões", "432432532");
		Bookstore bStore = new Bookstore();
		
		new Expectations() {{ 
			service.addBook(book); times = 1;
		}};
		bStore.addBook(book);
	}
	
	@Test(expectedExceptions=NullPointerException.class)
	public void addNull() throws Throwable{
		final Book book = null;
		Bookstore bStore = new Bookstore();
		
		new Expectations() {{ 
			service.addBook(book); times = 0;
		}};
		bStore.addBook(book);
	}
	
	@Test(expectedExceptions=CannotProcessRequestException.class)
	public void addUnavailableService() throws Throwable {
		final Book book = new Book("Lúsiadas", new BigDecimal(10), "Luís Vaz de Camões", "432432532");
		Bookstore bStore = new Bookstore();
		
		new Expectations() {{ 
			service.addBook(book);
			result = new ServiceUnavailableException();
		}};
		bStore.addBook(book);
	}
}
