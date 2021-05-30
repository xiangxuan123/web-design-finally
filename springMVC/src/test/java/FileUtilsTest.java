import com.example.springmvc.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Path;

@SpringBootTest
public class FileUtilsTest {
    @Test
    public void test1(){
        File file = new File("D://a.txt");
        assert file.exists();
        System.out.println("1");
        //long siz = FileUtils.getSize(Path.of("D://a.txt"));
    }
}
