import org.lwjgl.*;

import graphics.Window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.Callbacks.*;

public class Main {

	static Window window = new Window();

	public static void run() {
		System.out.println("Running game! LWJGL version: " + Version.getVersion());

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