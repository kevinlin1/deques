import deques.ArrayDeque;
import deques.Deque;

/**
 * Simulate web browser history using deques.
 */
public class BrowserHistory {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        history.addLast("ucsd.edu");
        // Latest page is "ucsd.edu". Visit "mytritonlink.ucsd.edu"...
        history.addLast("mytritonlink.ucsd.edu");
        // Latest page is "mytritonlink.ucsd.edu". Visit "datascience.ucsd.edu"...
        history.addLast("datascience.ucsd.edu");
        // Latest page is "datascience.ucsd.edu". Visit "canvas.ucsd.edu"...
        history.addLast("canvas.ucsd.edu");
        System.out.println(history);

        // Latest page is "canvas.ucsd.edu". Remove this page from the history...
        history.removeLast();
        // Latest page is "datascience.ucsd.edu". Visit "blink.ucsd.edu"...
        history.addLast("blink.ucsd.edu");
        // Latest page is "blink.ucsd.edu". Remove the oldest two pages from the history...
        history.removeFirst();
        history.removeFirst();
        System.out.println(history);
    }
}
