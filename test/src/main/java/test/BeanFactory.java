package test;

public class BeanFactory {
	public Object getBean(String beanName) { // beanName을 들으면 객체를 반환한다.
		if(beanName.equals("galaxy")) {
			return new Galaxy();
		}
		else if(beanName.equals("iphone")) {
			return new IPhone();
		}
		return null;
	}
}
