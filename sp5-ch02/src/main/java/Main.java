// 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리합니다.
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		// 객체를 생성 시 AppContext 클래스를 생성자 파라미터로 전달합니다.
		// AppContext에 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화 합니다.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

		// getBean: AnnotationConfigApplicationContext 가 자바 설정을 읽어와 생성한 빈 객체를 검색시 사용됩니다.
		// 첫 번째 파라미터: @Bean 어노테이션의 메서드 이름인 빈 객체의 이름입니다.
		// 두 번째 파라미터: 검색할 빈 객체의 타입입니다.
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("(g1 == g2) = " + (g1 == g2));


		
		// => 결과값은 True 가 나옵니다.
		// 즉 g1과 g2가 같은 객체라는 의미입니다.
		ctx.close();
	}
}
