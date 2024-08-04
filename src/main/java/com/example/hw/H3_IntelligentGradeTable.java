package com.example.hw;

import java.util.*;

/**
 * <p>智能成绩表</p>
 * <p>
 *     第1行输入两个整数，学生人数n和科目数量m。0 < n < 100,0 < m < 10
 *     第2行输入m个科目名称，彼此之间用空格隔开。科目名称只由英文字母构成，单个长度不超过10个字符。科目的出现顺序和后续输入的学生成绩一一对应。不会出现重复的科目名称。
 *     第3行开始的n行，每行包含一个学生的姓名和该生m个科目的成绩(空格隔开)，学生不会重名。学生姓名只由英文字母构成，长度不超过10个字符。成绩是0~100的整数，依次对应第2行中输入的科目。
 *     第n+2行，输入用作排名的科目名称。若科目不存在，则按总分进行排序
 * </p>
 * <p>
 *     输出一行，按成绩排序后的学生名字，空格隔开。成绩相同的按照学生姓名字典顺序排序。
 * </p>
 * @author zhenwu
 * @date 2024/6/26 21:44
 */
public class H3_IntelligentGradeTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] metadataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int studentCount = metadataArray[0];
        int subjectCount = metadataArray[1];

        String[] subjectArray = in.nextLine().split(" ");
        List<Student> studentList = new ArrayList<>(studentCount);
        for (int i = 0; i < studentCount; i++) {
            String[] strArr = in.nextLine().split(" ");
            Student student = new Student(strArr[0], subjectCount);
            for (int j = 0; j < subjectCount; j++) {
                student.score.put(subjectArray[j], Integer.parseInt(strArr[j + 1]));
            }
            student.calTotalScore();
            studentList.add(student);
        }

        String sortRule = in.nextLine();
        if (studentList.get(0).score.containsKey(sortRule)) {
            studentList.sort((o1, o2) -> {
                int res = o2.score.get(sortRule) - o1.score.get(sortRule);
                return res == 0 ? o1.name.compareTo(o2.name) : res;
            });
        } else {
            studentList.sort((o1, o2) -> {
                int res = o2.totalScore - o1.totalScore;
                return res == 0 ? o1.name.compareTo(o2.name) : res;
            });
        }
        studentList.forEach(student -> System.out.print(student.name + " "));
    }

    private static class Student {
        final String name;
        final Map<String, Integer> score;
        int totalScore;

        public Student(String name, int subjects) {
            this.name = name;
            this.score = new HashMap<>(subjects);
        }

        public void calTotalScore() {
            int sum = 0;
            for (int score : score.values()) {
                sum += score;
            }
            totalScore = sum;
        }
    }
}
