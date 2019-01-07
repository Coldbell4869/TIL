package my.examples.miniwebserver;

/**
 * 요 순서로 채팅 만들었음!
 * chatUser
 * chatHouse
 * chatRoom
 * chatServer
 * chatServerMain
 * chatserverHandler
 * chatClient
 * chatClientMain
 * chatClientHandler
 */

public class ChatClientMain {
    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient("127.0.0.1" , 9999);
        chatClient.run();
    }
}

