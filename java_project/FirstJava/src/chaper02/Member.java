package chaper02;

public class Member {
	
	/*
	�� String Ÿ���� �̸��� ������ �� �ִ� ���� name�� �����غ��ô�.
	�� int Ÿ���� ���̸� ������ �� �ִ� ���� age�� �����غ��ô�.
	�� double Ÿ���� Ű�� ������ �� �ִ� ���� height�� �����غ��ô�.
	�� boolean Ÿ���� JAVAå�� ���� ���θ� ������ �� �ִ� ���� hasBook�� �����غ��ô�.
	�� �̸��� ����, Ű, å�� ���� ���θ� ����غ��ô�.
	*/
	
	// Ŭ���� ����
	// [����������] [final] Ŭ���� �̸� {}
	// {
	// 		���� ����
	// 		�޼ҵ� ����
	// }
	// �ν��Ͻ� ������ �ڵ� �ʱ�ȭ
	String name;	// ������� �̸�
	int age; 		// ������� ����
	double height;  // ������� Ű
	boolean hasBook; // �ڹ� å ��������
	
	// ȸ���� �����͸� ����ϴ� �޼ҵ�
	void printData() {
		System.out.println("�̸�:" + name);
		System.out.println("����:" + age);
		System.out.println("Ű:" + height);
		System.out.println("�ڹ� å ��������:" + hasBook);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		// Member Ŭ������ �ν��Ͻ��� ���� -> �̸�, ����, Ű, å�������� ������ �� �ִ� �޸𸮰����� ����
		Member member = new Member();
		
		// �ν��Ͻ��� ������ �����ؼ� ���
//		System.out.println("�̸�:" + member.name);
//		System.out.println("����:" + member.age);
//		System.out.println("Ű:" + member.height);
//		System.out.println("�ڹ� å ��������" + member.hasBook);
		
		member.printData();
		
		// �ν��Ͻ� ������ ���� ����
		member.name = "�ȳ���";
		member.age = 20;
		member.height = 190.3;
		member.hasBook = true;
		
		System.out.println("----------------------------");
		System.out.println("�ν��Ͻ� ������ ���� ����");
		System.out.println("----------------------------");

		member.printData();

		
//		System.out.println("�̸�:" + member.name);
//		System.out.println("����:" + member.age);
//		System.out.println("Ű:" + member.height);
//		System.out.println("�ڹ� å ��������" + member.hasBook);
				
		// ���� �ڵ�� => �޼ҵ�� ���� => Member Ŭ�������� �޼ҵ带 ����
		
		
		

	}
	
	
	
	
	
	
	
	

}











