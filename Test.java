import markup.*;

import java.util.Collections;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Paragraph paragraph = new Paragraph(Collections.singletonList(
                new Strong(Arrays.asList(
                        new Text("1"),
                        new Strikeout(Arrays.asList(
                                new Text("2"),
                                new Emphasis(Arrays.asList(
                                        new Text("3"),
                                        new Text("4")
                                )),
                                new Text("5")
                        )),
                        new Text("6")
                ))
        ));
        StringBuilder str = new StringBuilder();
        paragraph.toMarkdown(str);
        System.out.println(str.toString());
    }
}
