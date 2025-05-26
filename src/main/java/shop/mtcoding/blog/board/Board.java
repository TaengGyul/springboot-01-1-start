package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data // getter, setter, toString 등을 컴파일 시 자동으로 생성
@Table(name = "board_tb") // 테이블 이름을 'board_tb'로 정의
@Entity // 이 클래스가 데이터베이스 테이블과 매핑되는 엔티티임을 명시
public class Board {
    @Id // id 필드를 Primary Key로 설정
    // id에 auto_increment 설정(insert 될때 마다 번호가 1씩 증가하여 저장됨)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // id 컬럼 생성
    private String title; // title 컬럼 생성
    private String content; // content 컬럼 생성
    private Timestamp createdAt; // createdAt 컬럼 생성
}
