package es.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@SpringBootApplication
@EnableWebSocket
public class Application implements WebSocketConfigurer {

	private static ConfigurableApplicationContext app;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new TicTacToeHandler(), "/tictactoe");
	}
	    
    public static void start() {
    	start(new String[] {});
    }

	private static void start(String[] args) {
		if(app == null) {
    		app = SpringApplication.run(Application.class, args);
    	} 
	}    
	
	public static void stop() {
		if(app != null) {
			app.close();
		}
	}
}
