package soundsystem.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;    // private이고 여기에 값을 넣어준적이 없지만 null이 안뜨고 잘 값이 들어감. 만능 리플렉션..ㄷㄷ해

//    public BookService(BookDao bookDao){
//        this.bookDao = bookDao;
//        System.out.println("BookService()");
//    }

    public void service(){
        bookDao.crud();
    }
}
