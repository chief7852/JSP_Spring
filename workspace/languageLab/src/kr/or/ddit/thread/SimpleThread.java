package kr.or.ddit.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 1부터 100까지의 숫자를 매 1초마다 한번씩 1씩 증가하면서 콘솔에 출력
 * 1번의 작업을 매 2초마다 한번씩 반복
 * 최대 쓰레드의 갯수는 10개 미만으로 제한
 */
public class SimpleThread {
	
	public static void main(String[] args) {
//		PrintNumberJobGenerator pr = new PrintNumberJobGenerator();
//		Thread tr = new Thread(pr);
//		tr.start();
	}
//	public static void main(String[] args) {
//		
//		ExecutorService ex = Executors.newFixedThreadPool(10);
//		Runnable tr = new SimpleThread();
//		while(true) {
//			Thread tr2 = new Thread(tr);
//			tr2.setDaemon(true);
//			ex.submit(tr2);
//			
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
//
//	@Override
//	public void run() {
//		int i = 0;
//		while(i<=100) {
//			i++;
//			try {
//				System.out.println(i);
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
	
}



