package part1;

public class Ex5Program_Join_Wating {

	public static void main(String[] args) {

		Thread th = Thread.currentThread();
		th.setName("Main3");
		
		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				System.out.printf("%s: %s\n", th.getName(), th.getState());
				print();
				System.out.printf("%s: %s\n", th.getName(), th.getState()); // WAITING

			}
		};

		
		Thread th1 = new Thread(subMain);
		th1.setName("sub1");

		System.out.printf("%s: %s\n", th1.getName(), th1.getState()); // NEW
		
		th1.start(); // RUNNING
		
		System.out.printf("%s: %s\n", th1.getName(), th1.getState()); // RUNNABLE
		System.out.printf("%s: %s\n", th1.getName(), th1.getState()); // sleep()에 걸리면 TIMED_WAITING
		System.out.printf("%s: %s\n", th1.getName(), th1.getState());
		System.out.printf("%s: %s\n", th1.getName(), th1.getState());

		
//		print();
		
		System.out.printf("%s: %s\n", th1.getName(), th1.getState()); // TERMINATED
		
		if(th1.isAlive()) {
			try {
				th1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("============Main Exit=====================");

	}

	private static void print() {
		for (int i = 0; i < 100; i++) {
			Thread th = Thread.currentThread();

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (th.getName().equals("Main3")) 
				System.out.printf("<%s[%d]: %d>\n", th.getName(), th.getId(), i + 1);
			else
				System.out.printf("%s[%d]: %d\n", th.getName(), th.getId(), i + 1);
		}
	}

}