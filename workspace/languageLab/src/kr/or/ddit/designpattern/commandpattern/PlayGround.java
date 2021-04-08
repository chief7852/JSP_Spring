package kr.or.ddit.designpattern.commandpattern;

public class PlayGround {
	public static void main(String[] args) {
		//백엔드 핸들러
		Receiver1 recv1 = new Receiver1();
		//프론트커맨더
		Invoker1Nopattern iv1 = new Invoker1Nopattern(recv1);
		iv1.order();
		
		Receiver2 recv2 =new Receiver2();
		Invoker2NoPattern iv2 = new Invoker2NoPattern(recv2);
		iv2.order();
		
		
		// command pattern 적용후
		
		Command command1 = new ConcreteCommand(recv1);
		Command command2 = new ConcreteCommand2(recv2);
		
		
		Invoker front = new Invoker(command1,command2);
		front.order(1);// 숫자는 url
		front.order(0);
		front.order(7);
		
	}
}
