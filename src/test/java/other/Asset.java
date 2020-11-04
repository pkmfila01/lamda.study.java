package other;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Asset {
    public enum AssetType { BOND, STOCK };
    private final AssetType type;
    private final int value;
}
