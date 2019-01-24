package soundsystem.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;    // private이고 여기에 값을 넣어준적이 없지만 null이 안뜨고 잘 값이 들어감. 만능 리플렉션..ㄷㄷ
    //  @Autowired 애노테이션은 타입으로 오토와이어링을 하는 방식.
    //  타입으로 오토와이어링을 할 때는 기본적으로 의존성 주입이 반드시 성공한다고 가정.(private이여도 값을 넣을 수 있다.)

    public BookService(BookDao bookDao){
        this.bookDao = bookDao;
        System.out.println("BookService()");
    }

    public void service(){
        bookDao.crud();
    }
}