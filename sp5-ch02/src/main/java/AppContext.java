import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration: 해당 클래스를 스프링 설정 클래스로 지정합니다.
@Configuration
public class AppContext {

	// Bean: 스프링을 생성하는 객체를 의미합니다.
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		return g;
	}

}
