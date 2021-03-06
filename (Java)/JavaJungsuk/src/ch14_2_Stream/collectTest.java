package ch14_2_Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class collectTest {
	public static void main(String[] args) {

		Student11[] stuArr = { new Student11("나자바", true, 1, 1, 300), new Student11("김지미", false, 1, 1, 250),
				new Student11("김자바", true, 1, 1, 200), new Student11("이지미", false, 1, 2, 150),
				new Student11("남자바", true, 1, 2, 100), new Student11("안지미", false, 1, 2, 50),
				new Student11("황지미", false, 1, 3, 100), new Student11("강지미", false, 1, 3, 150),
				new Student11("이자바", true, 1, 3, 200), new Student11("나자바", true, 2, 1, 300),
				new Student11("김지미", false, 2, 1, 250), new Student11("김자바", true, 2, 1, 200),
				new Student11("이지미", false, 2, 2, 150), new Student11("남자바", true, 2, 2, 100),
				new Student11("안지미", false, 2, 2, 50), new Student11("황지미", false, 2, 3, 100),
				new Student11("강지미", false, 2, 3, 150), new Student11("이자바", true, 2, 3, 310) };

		Stream<Student11> sts = Stream.of(stuArr);

		List<String> list = sts.map(Student11::getName).collect(Collectors.toList());
		list.forEach(System.out::println);

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		Stream<Student11> sts1 = Stream.of(stuArr);

		Set<String> set = sts1.map(Student11::getName).collect(Collectors.toSet());
		set.forEach(System.out::println);

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		Stream<Student11> sts3 = Stream.of(stuArr);

		ArrayList<String> alist = sts3.map(Student11::getName).collect(Collectors.toCollection((ArrayList::new)));
		alist.forEach(System.out::println);

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		Stream<Student11> sts11 = Stream.of(stuArr);

		Object[] ss = sts11.toArray();
		System.out.println(ss[0]);

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		Stream<Student11> sts17 = Stream.of(stuArr);

		long count = sts17.collect(Collectors.counting());
		System.out.println(count);

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		Stream<Student11> sts18 = Stream.of(stuArr);
		int tt = sts18.collect(Collectors.summingInt(Student11::getScore));
		System.out.println(tt);

		System.out.println();//////////////////////////////////////////////////////////////////////////////////
		Stream<Student11> sts19 = Stream.of(stuArr);
		int sum = sts19.mapToInt(Student11::getScore).sum();
		System.out.println(sum);

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		Stream<Student11> sts20 = Stream.of(stuArr);
		Optional<Student11> topStudent = sts20.collect(Collectors.maxBy(Comparator.comparingInt(Student11::getScore)));
		System.out.println(topStudent);

		System.out.println();//////////////////////////////////////////////////////////////////////////////////
		Stream<Student11> sts22 = Stream.of(stuArr);
		String names = sts22.map(Student11::getName).collect(Collectors.joining(",", "[", "]"));
		System.out.println(names);

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		Map<Boolean, List<Student11>> mf = Stream.of(stuArr).collect(Collectors.partitioningBy(Student11::isMale));
		System.out.println(mf.get(false));

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		// 성별 1등

		Map<Boolean, Object> no1 = Stream.of(stuArr).collect(Collectors.partitioningBy(Student11::isMale, Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student11::getScore)), Optional::get)));

		System.out.println(no1.get(true));

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		// 100점 미만구해봐

		Map<Boolean, List<Student11>> fail = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(s -> s.getScore() <= 100));

		System.out.println("dd");
		System.out.println(fail.get(true));

		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		// 반별로 그룹화해봐

		Map<Integer, List<Student11>> ban = Stream.of(stuArr).collect(Collectors.groupingBy(Student11::getBan));

		for (List<Student11> bban : ban.values()) {
			for (Student11 b : bban) {
				System.out.println(b);
			}
			System.out.println();
		}
		
		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		// 성적별로 그룹화
		System.out.println("성적별로");
		
		Map<Student11.Level, List<Student11>> sco = Stream.of(stuArr).collect(Collectors.groupingBy(s-> {
			if (s.getScore() >= 200) return Student11.Level.HIGH;
			else if (s.getScore() >= 100) return Student11.Level.MID;
			else return Student11.Level.LOW;
		}));
		
		TreeSet<Student11.Level> ts = new TreeSet<>(sco.keySet());
		
		
		for(Student11.Level key: ts) {
			System.out.println(key);
		for(Student11 gap:sco.get(key)) {
			System.out.println(gap);
		}
			System.out.println();
		}
		
		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		// 성적별 학생수
		Map<Student11.Level, Long> soo = Stream.of(stuArr).collect(Collectors.groupingBy(s-> {
			if(s.getScore()>=200) return Student11.Level.HIGH;
			else if (s.getScore() >= 100) return Student11.Level.MID;
			else return Student11.Level.LOW;
		}, Collectors.counting())  );
		
		for(Student11.Level key : soo.keySet()) {
			System.out.printf("[%s]: %d명%n", key, soo.get(key));
		}
		
		System.out.println();//////////////////////////////////////////////////////////////////////////////////

		// 학년별반별

		Map<Integer, Map<Integer, List<Student11>>> hac =
		Stream.of(stuArr).collect(Collectors.groupingBy(Student11::getHak, Collectors.groupingBy(Student11::getHak)));
		
		for(Map<Integer, List<Student11>> hak:hac.values()) {
			for(List<Student11> kk:hak.values()) {
				for(Student11 s : kk) {
					System.out.println(s);
				}
			}
			System.out.println();
			
		}

		
		
		
		

	}

}

class Student11 {
	String name;
	boolean isMale; // 성별
	int hak; // 학년
	int ban; // 반
	int score;

	Student11(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	String getName() {
		return name;
	}

	boolean isMale() {
		return isMale;
	}

	int getHak() {
		return hak;
	}

	int getBan() {
		return ban;
	}

	int getScore() {
		return score;
	}

	public String toString() {
		return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
	}
	
	enum Level {
		HIGH, MID, LOW
	}

}