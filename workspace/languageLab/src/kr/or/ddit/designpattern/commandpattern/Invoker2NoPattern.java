package kr.or.ddit.designpattern.commandpattern;

import kr.or.ddit.annotation.FirstAnnotation;

@FirstAnnotation(number=3)
public class Invoker2NoPattern {
	
	public Invoker2NoPattern() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Receiver2 recv2;
	
	public Invoker2NoPattern(Receiver2 recv2) {
		super();
		this.recv2 = recv2;
	}

	public void order() {
		recv2.specificOperate2();
	}
}
