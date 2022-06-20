import org.glassfish.jersey.test.JerseyTest;

/**
 * @author gxd18
 * @create 2022/3/30 17:03
 */
public class Test extends JerseyTest {


    public void should_test(){
        String path = target().getUri().getPath();
    }
}
