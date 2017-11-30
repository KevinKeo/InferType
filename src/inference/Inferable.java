package inference;

import type.Type;

/**
 * Created by borsing on 30/11/17.
 */
public interface Inferable {
    Type infer(Infer infer);

}
