package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "soundsystem.book")   // soundesystem.book 패키지 이하에서 클래스를 찾는다.
public class BookConfig {
}
