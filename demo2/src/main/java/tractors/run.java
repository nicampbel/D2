package tractors;

import java.io.IOException;

public class run {

    public void InitializeJADE(String[] args) {
        String jadelibPath = "NULL";
        String classesPath = "NULL";
        jadelibPath = "C:\\Users\\campb\\OneDrive - Stellenbosch University\\3 Modules\\Holonics\\D2\\JADE\\lib";
        classesPath = "C:\\Users\\campb\\OneDrive - Stellenbosch University\\3 Modules\\Holonics\\D2\\demo2\\target\\classes";
        
        String cmdSetJadelib = "set JADELIB=" + jadelibPath + " && ";

        String cmdSetClasspath = "set CLASSPATH=%JADELIB%\\jade.jar;%JADELIB%\\jadeTools.jar;%JADELIB%\\http.jar;%JADELIB%\\commons-codec\\commons-codec-1.3.jar && ";

        String openGui = "java -cp \"" + classesPath + ";" + jadelibPath + "\\*\" jade.Boot -gui";

        String[] commands = new String[] { "cmd", "/c", cmdSetJadelib + cmdSetClasspath + openGui };

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            processBuilder.inheritIO(); // Redirect subprocess output to the current process
            Process process = processBuilder.start();
            process.waitFor(); // Wait for the subprocess to finish
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run executeJADE = new run();
        executeJADE.InitializeJADE(args);
    }
}