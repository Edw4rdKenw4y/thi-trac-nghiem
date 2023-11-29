package classes.function;

import classes.question.Question;
import classes.repository.*;
import classes.util.Constant;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorMenu {
    public void professor(String quesfile){
        Scanner sc = new Scanner(System.in);
        QuestionRepository questionRepository = new QuestionRepository(quesfile);
        while (true) {
            // them sua xoa cau hoi
            // tao de thi
            // them de thi
            // xem ket qua
            System.out.println("[1]. Hien thi danh sach cau hoi");
            System.out.println("[2]. Them cau hoi");
            System.out.println("[3]. Tim kiem cau hoi");
            System.out.println("[4]. Hien thi danh sach de thi");
            System.out.println("[5]. Tao de thi");
            System.out.println("[6]. Xem kết quả bài kiểm tra");
            System.out.println("[7]. Đăng xuất");

            System.out.println("Nhap lua chon: ");
            int adminChoice = sc.nextInt();
            sc.nextLine(); // consume the newline character

            switch (adminChoice) {
                case 1:
                    System.out.println("Danh sach cau hoi:");
                        for (Question ques : questionRepository.getQuesbank().getQuesList()) {
                    System.out.println(ques);
                    }
                    break;

                case 2:
                    System.out.println("Chon chuong :");
                    int chapter = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhap noi dung cau hoi: ");
                    String content = sc.nextLine();
                    System.out.println("Nhập độ khó: [1].Dễ - [2].Trung bình - [3]]Khó ");
                    int difficulty = sc.nextInt();
                    sc.nextLine(); // consume the newline character
            
                    String[] answer = new String[4];
                    for (int i = 0; i < answer.length; i++) {
                        System.out.println("Nhap cac dap an " + (i + 1) + ": ");
                        answer[i] = sc.nextLine();
                    }
                    
                    System.out.println("Nhap dap an dung [1 - 4]: ");
                    int correctAnswer = sc.nextInt();
                    sc.nextLine(); // consume the newline character

                    Question newQuestion = new Question(chapter, difficulty, content, answer, correctAnswer);
                    questionRepository.addQuestion(newQuestion);
                    System.out.println("Câu hỏi đã được thêm.");
                        break;
                    

                case 3:
                        System.out.println("Tim kiem theo:");
                        System.out.println("[1]. Noi dung");
                        System.out.println("[2]. Chuong");
                        System.out.println("[3]. Do kho");
                        int searchCriteria = sc.nextInt();
                        sc.nextLine(); // consume the newline character
                        ArrayList<Question> quesArr =  new ArrayList<Question>();
                        switch (searchCriteria) {
                            case 1:
                                System.out.println("Nhap noi dung can tim kiem: ");
                                String contentSearch = sc.nextLine();
                                ArrayList<Question> contentSearchResult = questionRepository.searchQuestionByContent(contentSearch);
                                quesArr = contentSearchResult;
                                if (contentSearchResult.isEmpty()) {
                                    System.out.println("Khong tim thay ket qua.");
                                } else {
                                    System.out.println("Ket qua tim kiem:");
                                   
                                        for (int i = 0; i < quesArr.size(); i++) {
                                            Question question = quesArr.get(i);
                                            System.out.println("["+ i +"]." + question);
                                            
                                            
                                    }
                                    System.out.println("chon cau hoi:");
                                    int selectedQuestion = sc.nextInt();
                                    sc.nextLine();
                                    // thiếu
                                    // Thêm lựa chọn sửa và xóa
                                            System.out.println("1. Sua");
                                            System.out.println("2. Xoa");
                                            System.out.println("3. Quay lai");
                                            System.out.println("Nhap lua chon: ");
                                            int choice = sc.nextInt();
                                            sc.nextLine();

                                            // switch (choice) {
                                            //     case 1:
                                            //         // new content, new diff, new answer, new corr ans
                                            //         questionRepository.modifyQuestion(i, question);
                                            //         break;
                                            //     case 2:
                                            //         questionRepository.removeQuestion(i);
                                            //         System.out.println("cau hoi da duoc xoa!");
                                            //         quesArr.remove(i);
                                            //         i--; // Đảm bảo vòng lặp không bị lỗi do việc xóa phần tử
                                            //         break;
                                            //     case 3:
                                            //         // Tiếp tục tìm kiếm
                                            //         break;
                                            //     default:
                                            //         System.out.println("Lua chon khong hop le.");
                                            //         break;
                                            // }
                                }

                                break;

                            case 2:
                                System.out.println("Nhap chuong can tim kiem: ");
                                int chapterSearch = sc.nextInt();
                                ArrayList<Question> chapterSearchResult = questionRepository.searchQuestionByChapter(chapterSearch);
                                quesArr = chapterSearchResult;
                                if (chapterSearchResult.isEmpty()) {
                                    System.out.println("Khong tim thay ket qua.");
                                } else {
                                    System.out.println("Ket qua tim kiem:");
                                    for (Question ques : chapterSearchResult) {
                                        System.out.println(ques);
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("Nhap do kho can tim kiem [1].De - [2].Trung binh - [3].Kho: ");
                                int difficultySearch = sc.nextInt();
                                ArrayList<Question> difficultySearchResult = questionRepository.searchQuestionByDiffi(difficultySearch);
                                quesArr = difficultySearchResult;
                                if (difficultySearchResult.isEmpty()) {
                                    System.out.println("Khong tim thay ket qua.");
                                } else {
                                    System.out.println("Ket qua tim kiem:");
                                    for (Question ques : difficultySearchResult) {
                                        System.out.println(ques);
                                    }
                                }
                                break;
                            default:
                                System.out.println("Lua chon khong hop le.");
                                break;
                        }
                    break;

                case 4:
                    // Xóa người dùng
                    
                    break;

                case 5:
                    // Đăng xuất

                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
    
}
