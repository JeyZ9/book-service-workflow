package com.app.jeyz9.booksservice.seeders;

import com.app.jeyz9.booksservice.models.Book;
import com.app.jeyz9.booksservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final BookRepository bookRepository;
    
    @Autowired
    public DatabaseSeeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    public void run(String... args){
        if(bookRepository.count() == 0L){
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book(
                    "โลกของโซฟี",
                    "ปรัชญา",
                    "https://storage.naiin.com/system/application/bookstore/resource/product/202401/600402/1000268236_front_XXL.jpg"
            ));
            bookList.add(new Book(
                    "เจ้าชายน้อย",
                    "วรรณกรรมเยาวชน",
                    "https://image.makewebcdn.com/makeweb/m_1920x0/7GFEYsdVK/DefaultData/%E0%B9%80%E0%B8%88%E0%B9%89%E0%B8%B2%E0%B8%8A%E0%B8%B2%E0%B8%A2%E0%B8%99%E0%B9%89%E0%B8%AD%E0%B8%A2_2.jpg"
            ));
            bookList.add(new Book(
                    "Harry Potter and the Philosopher's Stone",
                    "แฟนตาซี",
                    "https://bci.kinokuniya.com/th/jsp/images/book-img/97814/97814088/9781408855652.JPG"
            ));
            bookList.add(new Book(
                    "1984 - George Orwell",
                    "นิยายวิทยาศาสตร์, ดิสโทเปีย",
                    "https://bci.kinokuniya.com/jsp/images/book-img/97801/97801410/9780141036144.JPG"
            ));
            bookList.add(new Book(
                    "ประวัติศาสตร์ช็อกโกแลต ฉบับเข้มข้น (The True History of Chocolate)",
                    "สารคดี",
                    "https://bookscape.co/wp-content/uploads/2023/06/Chocolate_COVER_05-01-copy.png"
            ));
            bookList.add(new Book(
                    "บ้านเล็กในป่าใหญ่",
                    "สารคดี, ธรรมชาติ",
                    "https://library.wu.ac.th/content/wp-content/uploads/sites/8/2020/05/%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99%E0%B9%80%E0%B8%A5%E0%B9%87%E0%B8%81%E0%B9%83%E0%B8%99%E0%B8%9B%E0%B9%88%E0%B8%B2%E0%B9%83%E0%B8%AB%E0%B8%8D%E0%B9%88-e1729920858961.jpg"
            ));
            bookList.add(new Book(
                    "ดินแดนไร้เเสง",
                    "แฟนตาซี, วรรณกรรมไทย",
                    "https://image.makewebcdn.com/makeweb/m_1920x0/7GFEYsdVK/DefaultData/NTE_front_cover.png?v=202405291424"
            ));
            bookList.add(new Book(
                    "ความสุขของกะทิ",
                    "วรรณกรรมไทย",
                    "https://storage.naiin.com/system/application/bookstore/resource/product/201609/200085/1000189367_front_XXL.jpg"
            ));
            bookList.add(new Book(
                    "หนังสือที่ไม่มีเรื่องราว",
                    "เรื่องสั้น, ไลฟ์สไตล์",
                    "https://platform-api.nanmeebooks.com/uploads/upload/file/cover_image/9786160448395.jpg"
            ));
            bookList.add(new Book(
                    "Sapiens: A Brief History of Humankind",
                    "ประวัติศาสตร์, มนุษยศาสตร์",
                    "https://m.media-amazon.com/images/I/713jIoMO3UL.jpg"
            ));
            bookRepository.saveAll(bookList);
        }
    }
}
