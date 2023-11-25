package classes.function;

import classes.question.Question;
import classes.repository.*;
// import classes.user.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorMenu {
    public void professor(){
        Scanner sc = new Scanner(System.in);
        AccountRepository accountRepository = new AccountRepository("acclist.txt");
        QuestionRepository questionRepository = new QuestionRepository("questionlist.txt");
        while (true) {
            // them sua xoa cau hoi
            // tao de thi
            // them de thi
            // xem ket qua
            System.out.println("[1]. Hiển thị danh sách câu hỏi");
            System.out.println("[2]. Thêm câu hỏi");
            System.out.println("[3]. Tim kiem cau hoi");
            System.out.println("[3]. Sửa thông tin câu hỏi");
            System.out.println("[4]. Xóa câu hỏi");
            System.out.println("[5]. Tạo đề thi");
            System.out.println("[6]. Xem kết quả bài kiểm tra");
            System.out.println("[7]. Đăng xuất");

            System.out.println("Nhap lua chon: ");
            int adminChoice = sc.nextInt();
            sc.nextLine(); // consume the newline character

            switch (adminChoice) {
                case 1:
                    System.out.println("Danh sách câu hỏi:");
                        for (Question ques : questionRepository.getQuesbank().getQuesList()) {
                    System.out.println(ques);
                    }
                    break;

                case 2:
                    System.out.println("Chon chuong :");
                    int chapter = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập nội dung câu hỏi: ");
                    String content = sc.nextLine();
                    System.out.println("Nhập độ khó (1 - Dễ, 2 - Trung bình, 3 - Khó): ");
                    int difficulty = sc.nextInt();
                    sc.nextLine(); // consume the newline character
            
                    String[] answer = new String[4];
                    for (int i = 0; i < answer.length; i++) {
                        System.out.println("Nhập câu trả lời " + (i + 1) + ": ");
                        answer[i] = sc.nextLine();
                    }
                    
                    System.out.println("Nhập câu trả lời đúng (1 - 4): ");
                    int correctAnswer = sc.nextInt();
                    sc.nextLine(); // consume the newline character

                    Question newQuestion = new Question(chapter, difficulty, content, answer, correctAnswer);
                    questionRepository.addQuestion(newQuestion);
                    System.out.println("Câu hỏi đã được thêm.");
                        break;
                    

                case 3:
                        System.out.println("Chọn tiêu chí tìm kiếm:");
                        System.out.println("[1]. Tìm kiếm theo nội dung");
                        System.out.println("[2]. Tìm kiếm theo chương");
                        System.out.println("[3]. Tìm kiếm theo độ khó");
                        int searchCriteria = sc.nextInt();
                        sc.nextLine(); // consume the newline character

                        switch (searchCriteria) {
                            case 1:
                                System.out.println("Nhập nội dung cần tìm kiếm: ");
                                String contentSearch = sc.nextLine();
                                ArrayList<Question> contentSearchResult = questionRepository.searchQuestionByContent(contentSearch);
                                if (contentSearchResult.isEmpty()) {
                                    System.out.println("Không tìm thấy kết quả.");
                                } else {
                                    System.out.println("Kết quả tìm kiếm:");
                                    for (Question ques : contentSearchResult) {
                                        System.out.println(ques);
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("Nhập chương cần tìm kiếm: ");
                                int chapterSearch = sc.nextInt();
                                ArrayList<Question> chapterSearchResult = questionRepository.searchQuestionByChapter(chapterSearch);
                                if (chapterSearchResult.isEmpty()) {
                                    System.out.println("Không tìm thấy kết quả.");
                                } else {
                                    System.out.println("Kết quả tìm kiếm:");
                                    for (Question ques : chapterSearchResult) {
                                        System.out.println(ques);
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("Nhập độ khó cần tìm kiếm (1 - Dễ, 2 - Trung bình, 3 - Khó): ");
                                int difficultySearch = sc.nextInt();
                                ArrayList<Question> difficultySearchResult = questionRepository.searchQuestionByDiffi(difficultySearch);
                                if (difficultySearchResult.isEmpty()) {
                                    System.out.println("Không tìm thấy kết quả.");
                                } else {
                                    System.out.println("Kết quả tìm kiếm:");
                                    for (Question ques : difficultySearchResult) {
                                        System.out.println(ques);
                                    }
                                }
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ.");
                                break;
                        }
                    break;

                case 4:
                    // Xóa người dùng
                    System.out.println("Nhập user name của người dùng cần xóa: ");
                    String deleteUsername = sc.nextLine();

                    if (accountRepository.removeUser(deleteUsername)) {
                        System.out.println("Người dùng đã được xóa.");
                    } else {
                        System.out.println("Không tìm thấy người dùng.");
                    }
                    break;

                case 5:
                    // Đăng xuất
                    System.out.println("Đăng xuất thành công.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
    
}
