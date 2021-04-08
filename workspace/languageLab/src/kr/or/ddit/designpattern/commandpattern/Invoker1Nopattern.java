package kr.or.ddit.designpattern.commandpattern;

import kr.or.ddit.annotation.FirstAnnotation;
import kr.or.ddit.annotation.SecondAnnotation;

@FirstAnnotation(value="invoker1",number=24)
public class Invoker1Nopattern {
	
	public Invoker1Nopattern() {
		super();
		// TODO Auto-generated constructor stub
	}


	private Receiver1 recv1 ;
	
	
	public Invoker1Nopattern(Receiver1 recv1) {
		super();
		this.recv1 = recv1;
	}

	@SecondAnnotation(url="/test.do")
	public void order() {
		recv1.specificOperate1();
	}
}
