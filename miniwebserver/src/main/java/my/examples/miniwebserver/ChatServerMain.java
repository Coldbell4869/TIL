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

public class ChatServerMain {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(9999);
            chatServer.run();
    }
}
