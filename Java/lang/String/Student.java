package Java.lang.String;

public class Student implements Comparable<Student> {

    int no;
    String name;


    public Student() {
    }

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [no=" + no + ", name=" + name + "]";
    }

    // 번호로 정렬
//	@Override
//	public int compareTo(Student other) {
//		// TODO Auto-generated method stub
//		return this.no - other.no;
//	}

    // 이름으로 정렬
    @Override
    public int compareTo(Student other) {
        // TODO Auto-generated method stub
        return this.name.compareTo(other.name);
    }


    /*
     * this  ===> no = 10 , name = "나타"
     * other ===> no = 4 ,name = "노다치"
     *
     * compareTo
     * 양의 정수 - this 순위가 뒤
     * 음의 정수 - this의 순위가 앞
     *  0        - this 와 other의 순위가 동일
     */


}
