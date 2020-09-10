package propertyfile.embedded;

import java.util.HashMap;
import java.util.Map;

public class PropertyFileLoader extends PropertyFileEmbeddedBaseListener {

    Map<String,String> props = new HashMap<>();

    @Override
    public void exitProp(PropertyFileEmbeddedParser.PropContext ctx) {
        String id = ctx.ID.getText();
        String value = ctx.STRING.getText();
        props.put(id, value);
    }
}
