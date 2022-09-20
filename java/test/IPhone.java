package test;

public class IPhone implements Phone{
	private AppleWatch watch;
	private int number;
	public IPhone() {
		System.out.println("아이폰 객체생성완료");
	}
	public IPhone(AppleWatch watch) {
		System.out.println("아이폰 객체생성완료22");
		this.watch=watch;
	}
	public IPhone(AppleWatch watch,int number) {
		System.out.println("아이폰 객체생성완료333");
		this.watch=watch;
		this.number=number;
	}
	@Override
	public void powerOn() {
		System.out.println("아이폰 전원 ON : "+this.number);
	}
	@Override
	public void powerOff() {
		System.out.println("아이폰 전원 OFF");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
	}
	
}
