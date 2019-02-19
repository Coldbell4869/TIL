package my.examples.blog.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.examples.blog.security.BlogSecurityUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TextWebSocketHandler인터페이스를 구현한다.
public class ChatSocketHandler extends TextWebSocketHandler {
    ObjectMapper objectMapper = new ObjectMapper();
    List<WebSocketSession> list = Collections.synchronizedList(new ArrayList<>());
    // 웹 소켓에 연결될 때 호출되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("접속===========================");
        System.out.println(session.getId());
        System.out.println("접속===========================");
        list.add(session);
    }

    // 메시지를 전송받았을때 호출되는 메소드
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("메시지가 왔어요...");
        System.out.println(session.getId() + ", " + message.getPayload());
        System.out.println("메시지가 왔어요...");
        AbstractAuthenticationToken principal = (AbstractAuthenticationToken)session.getPrincipal();
        BlogSecurityUser securityUser = (BlogSecurityUser)principal.getPrincipal();

        ChatMessage clientMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);


        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setName(securityUser.getName());
        chatMessage.setMessage(clientMessage.getMessage());
        String json = objectMapper.writeValueAsString(chatMessage);
        for(WebSocketSession wss : list){
            wss.sendMessage(new TextMessage(json));
        }
    }

    // 웹 소켓이 연결이 클로즈될때 호출되는 메소드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("접속 close===========================");
        System.out.println(session.getId());
        System.out.println("접속 close===========================");
        list.remove(session);
    }
}
