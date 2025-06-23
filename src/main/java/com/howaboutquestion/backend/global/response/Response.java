package com.howaboutquestion.backend.global.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.howaboutquestion.backend.global.common.ResponseMetadata;
import com.howaboutquestion.backend.global.common.StatusCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * packageName    : com.howaboutquestion.backend.global.response<br>
 * fileName       : Response.java<br>
 * author         : eunchang <br>
 * date           : 2025-06-19<br>
 * description    : {@link ResponseMetadata} 공통 성공 응답을 처리하는 커스텀 Response 클래스입니다. <br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 25.06.19          eunchang           최초생성<br>
 */

@Getter
@JsonPropertyOrder({"success", "status", "code", "message", "data"})
public final class Response<T> extends ResponseMetadata {
    private final T data;

    /**
     * 응답 데이터를 형식에 맞춰서 반환할 Response 클래스 생성자
     * @param data 응답 데이터
     */
    private Response(T data) {
        super(true, StatusCode.SUCCESS.getStatus(), StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage());
        this.data = data;
    }
//    Controller --> Resposne.success();
// 요청을 받고 응답 --> return Response.Success(); --> DTO --> 보낸다.

//    Exception --> throw new Error
//    () --> 에러 발생했구나

//    return ErrorResponse.create();
//    return Response.Success();



//

//
//    Reponse --> 순수 DTO 가져가냐 (이게 맞음) 단일 책임 원칙
//    DTO + Util로 가져가냐 --> 역할이 많지 않다. --> util여서 (가능?) | 큰 책임은 아니지 않나?
//    JWT 토만드는거 --> CORS --> 클래스 --> Secruity config

//    결합도 --> 응집도
//    Res


//    부모 |


//    return ResponseUtil.Succees();


    /**
     * 응답 데이터를 커스텀한 메시지와 함께 반환할 Reponse 클래스 생성자
     * @param data 응답 데이터
     * @param message 커스텀 메시지
     */
    private Response(T data, String message) {
        super(true, StatusCode.SUCCESS.getStatus(), StatusCode.SUCCESS.getCode(), message);
        this.data = data;
    }



    /**
     * 요청에 맞는 응답 데이터를 200 OK와 함께 반환합니다.
     * @param data 응답 데이터
     * @return 데이터를 포함한 200 OK 응답 객체
     * @param <T> 응답 데이터 타입
     */
    public static <T> Response<T> success (T data){
        return new Response<>(data);
    }

    /**
     * 요청에 맞는 응답 데이터와 메시지를 200 OK와 함께 반환합니다.
     * @param data 응답 데이터
     * @param message 응답과 함께 반환할 메시지
     * @return 데이터를 포함한 200 OK 응답 객체
     * @param <T> 응답 데이터 타입
     */
    public static <T> Response<T> success (T data, String message){
        return new Response<>(data, message);
    }

    /**
     * 200 OK 응답을 반환합니다.
     * @return 200 OK 응답 객체
     * @param <T> 응답 데이터 타입
     */
    public static <T> Response<T> empty(){
        return new Response<> (null);
    }
}
