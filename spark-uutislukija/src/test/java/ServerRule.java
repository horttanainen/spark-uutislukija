import org.junit.rules.ExternalResource;
import spark.Spark;


/**
 *
 * @author santeri
 */
public class ServerRule extends ExternalResource {
    
    protected void before() {
        String[] args = {};
        Main.main(args);
    }
    
    protected void after() {
        Spark.stop();
    }
}
