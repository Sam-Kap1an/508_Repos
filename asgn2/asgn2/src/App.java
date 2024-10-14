public class App {
    public static void main(String[] args) {
        Head head = new Head();
        Thread head_thread = new Thread(head);

        head_thread.start();
        


        
    }
}
