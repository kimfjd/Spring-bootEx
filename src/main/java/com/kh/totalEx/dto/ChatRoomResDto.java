package com.kh.totalEx.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class ChatRoomResDto {
    private String roomId; // 채팅방 ID, 서버에서 UUID를 통해 자동 생성
    private String name;
    private LocalDateTime regDate;

    @JsonIgnore
    private Set<WebSocketSession> sessions; //채팅방에 입장한 세션 정보를 담을 set

    public boolean isSessionEmpty(){
        return this.sessions.isEmpty();
    }
    @Builder
    public ChatRoomResDto(String roomId, String name, LocalDateTime regDate) {
        this.roomId = roomId;
        this.name = name;
        this.regDate = regDate;
        this.sessions = Collections.newSetFromMap(new ConcurrentHashMap<>()); // 동시성 문제를 해결하기 위해 ConcurrentHashMap 사용
    }
}
