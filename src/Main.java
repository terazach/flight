import graphics.*;

import org.lwjgl.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.Callbacks.*;

public class Main {

	private static Window window = new Window();

	public static void run() {
		System.out.println("Running game with LWJGL version: " + Version.getVersion());
		
		try {
			window.init(1280, 720, "Flight");
			window.gameLoop();

			glfwFreeCallbacks(window.glWindow);
			glfwDestroyWindow(window.glWindow);
		} finally {
			glfwTerminate();
		}
	}

	public static void main(String[] args) {
		run();
	}

}