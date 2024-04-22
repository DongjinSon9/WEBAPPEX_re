package org.zerock.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

//    시작페이지 번호
    private int start;
//    끝페이지 번호
    private int end;

//    이전 페이지의 존재 여부
    private boolean prev;
//    다음 페이지의 존재 여부
    private boolean next;

    private List<E> dtoList;

//    생성자 만들기. 파라미터 3개짜리.
//    페이지 계산방법
//    예)
//    기본, 1,2,3,4,5,6,7,8,9,10
//    페이지2, 2,3,4,5,6,7,8,9,10,11
//    페이지10, 10,11, 12, 13, 14, 15, 16, 17, 18, 19
    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

//        end 페이지 먼저 계산하기
//        예)
//        1/10 = 0.1 -(올림)-> 1 => 10
//        예2)
//        11페이지, 11/10 = 1.1 -> 2 => 20
//        딱 안 떨어지는 경우,
//        예) 게시글이 총 75개인 것으로 가정.
//        75/10 = 7.5 -> 8페이지
//        현재 페이지에서 끝 페이지가 고정으로 10으로 나옴.
        this.end = (int)(Math.ceil(this.page / 10.0))*10;

//        start 페이지 구하기
//        예)
//        end = 30 , start = 21
        this.start = this.end - 9;

//        last 값이 없어서 생성 후 end 멤버에 재사용하기
//        예) 게시글이 총 75개인 것으로 가정.
//        75/10 = 7.5 -> 8페이지
        int last = (int)(Math.ceil(total / (double) size));

//        결론,
//        예)
//        10 > 8 -> 8
        this.end = end > last ? last : end;

//        prev , 이전 페이지 존재 여부
        this.prev = this.start > 1;

//        next 존재 여부
//        예) 총 게시글 75개 가정
//        end =  8, size = 10 (고정)
//        75 > 80

        this.next = total > this.end*this.size;

    }

}
