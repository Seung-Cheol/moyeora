/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package moyeora.myapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("과제관리 시스템 서버 실행!");
        SpringApplication.run(App.class, args);
    };
}